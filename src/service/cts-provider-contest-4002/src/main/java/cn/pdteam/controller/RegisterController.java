package cn.pdteam.controller;

import cn.pdteam.dao.ContestInfoMapper;
import cn.pdteam.dao.RegisterMapper;
import cn.pdteam.exception.IllegalParticipationAuthorityException;
import cn.pdteam.pojo.CommonResponse;
import cn.pdteam.pojo.CommonResult;
import cn.pdteam.pojo.PageResult;
import cn.pdteam.pojo.contest.ShortContestInfo;
import cn.pdteam.pojo.contest.entity.RegisterInfo;
import cn.pdteam.pojo.contest.request.CancelSignUpContest2UserRequest;
import cn.pdteam.pojo.contest.request.NoEntryRequest;
import cn.pdteam.pojo.contest.request.SignUpContestRequest;
import com.alibaba.cloud.commons.lang.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/reg")
public class RegisterController {
    @Resource
    RegisterMapper registerMapper;
    @Resource
    ContestInfoMapper contestInfoMapper;
    @Resource
    RedisTemplate<String, Object> redisTemplateForSerializableObjects;

    @PostMapping("/signUp")
    public CommonResponse signUp(@RequestBody SignUpContestRequest request) {
        SetOperations<String, Object> setOperations = redisTemplateForSerializableObjects.opsForSet();
        if (Boolean.TRUE.equals(setOperations.isMember("contest:" + request.getContestId() + ":noEntry", request.getUser()))) {
            throw new IllegalParticipationAuthorityException("该用户已被禁止报名该比赛。");
        }
        registerMapper.signUp(request);
        return new CommonResponse(200, true, null);
    }

    @PostMapping("/noEntry")
    public CommonResponse noEntry(@RequestBody NoEntryRequest request) {
        if (registerMapper.checkSignUp(request.getContestId(), request.getUser())) {
            registerMapper.cancelSignUpByContestIdAndUser(new CancelSignUpContest2UserRequest(request.getContestId(), request.getUser()));
        }
        ShortContestInfo shortContestInfo = contestInfoMapper.queryShortContestInfo(request.getContestId());
        if (shortContestInfo != null) {
            SetOperations<String, Object> setOperations = redisTemplateForSerializableObjects.opsForSet();
            setOperations.add("contest:" + shortContestInfo.id() + ":noEntry", request.getUser());
        } else {
            throw new IllegalArgumentException("比赛不存在！");
        }
        return new CommonResponse(200, true, "User " + request.getUser()
                + " has been banned from contest " + shortContestInfo.name() + ".");
    }

    @DeleteMapping("/unban")
    public CommonResponse unban(@RequestBody NoEntryRequest request) {
        SetOperations<String, Object> setOperations = redisTemplateForSerializableObjects.opsForSet();
        if (Boolean.TRUE.equals(setOperations.isMember("contest:" + request.getContestId() + ":noEntry", request.getUser()))) {
            setOperations.remove("contest:" + request.getContestId() + ":noEntry", request.getUser());
        } else {
            throw new IllegalArgumentException("未禁止用户'" + request.getUser() + "'报名比赛！");
        }
        return new CommonResponse(200, true, "解禁成功！");
    }

    @DeleteMapping("/cancel/fromUser")
    public CommonResponse cancelRegisterFromUser(@RequestBody CancelSignUpContest2UserRequest request) {
        Integer count = registerMapper.cancelSignUpByContestIdAndUser(request);
        if (count == 0) {
            throw new IllegalArgumentException("该用户未报名！");
        }
        return new CommonResponse(200, true, "cancel success!");
    }

    @DeleteMapping("/cancel/fromAdmin/{id}")
    public CommonResponse cancelRegisterFromAdmin(@PathVariable("id") Integer registerId) {
        Integer count = registerMapper.cancelSignUpByRegId(registerId);
        if (count == 0) {
            throw new IllegalArgumentException("未查询到该报名信息！");
        }
        return new CommonResponse(200, true, "cancel success!");
    }

    @GetMapping("/check")
    public CommonResult checkSignUp(@RequestParam("contestId") String contestId,
                                    @RequestParam("user") String user) {
        return new CommonResult<>(200, "query success!", registerMapper.checkSignUp(contestId, user));
    }

    @GetMapping("/queryList/{contestId}")
    public CommonResult<PageResult<RegisterInfo>> queryRegisterInfoList(@PathVariable("contestId") String contestId,
                                                                        @RequestParam Map<String, Object> param) {
        int page = 1;
        int limit = 50;
        String search = "";
        if (!StringUtils.isEmpty((String) param.get("page"))) {
            page = Integer.parseInt((String) param.get("page"));
        }
        if (!StringUtils.isEmpty((String) param.get("limit"))) {
            limit = Integer.parseInt((String) param.get("limit"));
        }
        if (!StringUtils.isEmpty((String) param.get("search"))) {
            search = (String) param.get("search");
        }
        return new CommonResult<>(200, null,
                new PageResult<>(registerMapper.queryRegisterCount(search, contestId), limit, page,
                        registerMapper.queryRegisterUserList(page, limit, search, contestId)));
    }

    @GetMapping("/query/ban/{contestId}")
    public CommonResult<List<Object>> queryBannedAccounts(@PathVariable("contestId") String contestId) {
        SetOperations<String, Object> setOperations = redisTemplateForSerializableObjects.opsForSet();
        return new CommonResult<>(200, null,
                new ArrayList<>(Objects.requireNonNull(setOperations.members("contest:" + contestId + ":noEntry"))));
    }

}
