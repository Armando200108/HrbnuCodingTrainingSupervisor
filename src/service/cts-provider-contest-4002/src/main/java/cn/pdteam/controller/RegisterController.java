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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 用户报名比赛控制器
 *
 * @author Armando
 * @version 1.0
 */
@RestController
@RequestMapping("/reg")
public class RegisterController {
    @Resource
    RegisterMapper registerMapper;
    @Resource
    ContestInfoMapper contestInfoMapper;
    @Resource
    RedisTemplate<String, Object> redisTemplateForSerializableObjects;

    /**
     * 报名操作
     *
     * @param request 报名请求对象
     * @return 200：报名成功
     */
    @PostMapping("/signUp")
    @Transactional
    public CommonResponse signUp(@RequestBody SignUpContestRequest request) {
        // 初始化SetOperations
        SetOperations<String, Object> setOperations = redisTemplateForSerializableObjects.opsForSet();
        // 在redis中检查是否禁止该用户报名比赛
        if (Boolean.TRUE.equals(setOperations.isMember("contest:" + request.getContestId() + ":noEntry", request.getUser()))) {
            throw new IllegalParticipationAuthorityException("该用户已被禁止报名该比赛。");
        }
        // 向数据库写入报名信息
        registerMapper.signUp(request);
        return new CommonResponse(200, true, null);
    }

    /**
     * 禁止用户报名比赛
     *
     * @param request 封禁请求对象
     * @return 200：封禁成功
     */
    @PostMapping("/noEntry")
    @Transactional
    public CommonResponse noEntry(@RequestBody NoEntryRequest request) {
        // 检查是否已报名
        if (registerMapper.checkSignUp(request.getContestId(), request.getUser())) {
            // 如果报名则取消用户的报名
            registerMapper.cancelSignUpByContestIdAndUser(new CancelSignUpContest2UserRequest(request.getContestId(), request.getUser()));
        }
        // 为确保数据准确性，从数据库获取比赛简要信息
        ShortContestInfo shortContestInfo = contestInfoMapper.queryShortContestInfo(request.getContestId());
        if (shortContestInfo != null) {
            // 当比赛存在时，向redis写入封禁信息
            SetOperations<String, Object> setOperations = redisTemplateForSerializableObjects.opsForSet();
            setOperations.add("contest:" + shortContestInfo.id() + ":noEntry", request.getUser());
        } else {
            throw new IllegalArgumentException("比赛不存在！");
        }
        return new CommonResponse(200, true, "User " + request.getUser()
                + " has been banned from contest " + shortContestInfo.name() + ".");
    }

    /**
     * 取消禁止用户参与比赛
     *
     * @param request 禁止用户参与比赛请求对象
     * @return 200：解封成功
     */
    @DeleteMapping("/unban")
    public CommonResponse unban(@RequestBody NoEntryRequest request) {
        // 初始化 SetOperations
        SetOperations<String, Object> setOperations = redisTemplateForSerializableObjects.opsForSet();
        if (Boolean.TRUE.equals(setOperations.isMember("contest:" + request.getContestId() + ":noEntry", request.getUser()))) {
            // 当redis中存在封禁信息时，从redis删除该条数据
            setOperations.remove("contest:" + request.getContestId() + ":noEntry", request.getUser());
        } else {
            throw new IllegalArgumentException("未禁止用户'" + request.getUser() + "'报名比赛！");
        }
        return new CommonResponse(200, true, "解禁成功！");
    }

    /**
     * 用户自行取消报名比赛接口
     *
     * @param request 取消报名对象
     * @return 200：取消成功
     */
    @DeleteMapping("/cancel/fromUser")
    public CommonResponse cancelRegisterFromUser(@RequestBody CancelSignUpContest2UserRequest request) {
        Integer count = registerMapper.cancelSignUpByContestIdAndUser(request);
        if (count == 0) {
            throw new IllegalArgumentException("该用户未报名！");
        }
        return new CommonResponse(200, true, "cancel success!");
    }

    /**
     * 管理员取消用户报名
     *
     * @param registerId 报名信息id（db 中 primary-key）
     * @return
     */
    @DeleteMapping("/cancel/fromAdmin/{id}")
    public CommonResponse cancelRegisterFromAdmin(@PathVariable("id") Integer registerId) {
        Integer count = registerMapper.cancelSignUpByRegId(registerId);
        if (count == 0) {
            throw new IllegalArgumentException("未查询到该报名信息！");
        }
        return new CommonResponse(200, true, "cancel success!");
    }

    /**
     * 检查是否报名
     *
     * @param contestId 比赛id
     * @param user      用户名
     * @return 200：获取报名信息，data!=null证明已报名
     */
    @GetMapping("/check")
    public CommonResult checkSignUp(@RequestParam("contestId") String contestId,
                                    @RequestParam("user") String user) {
        return new CommonResult<>(200, "query success!", registerMapper.checkSignUp(contestId, user));
    }

    /**
     * 查询比赛报名人员列表
     *
     * @param contestId 比赛id
     * @param param     url参数，主要包括 page、limit、search.<br/>page：页码<br/>limit：每页数据条目<br/>search:搜索关键字
     * @return CommonResult<PageResult < RegisterInfo>> 注册信息列表项
     */
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

    /**
     * 查询封禁信息
     *
     * @param contestId 比赛id
     * @return 封禁人员列表
     */
    @GetMapping("/query/ban/{contestId}")
    public CommonResult<List<Object>> queryBannedAccounts(@PathVariable("contestId") String contestId) {
        SetOperations<String, Object> setOperations = redisTemplateForSerializableObjects.opsForSet();
        return new CommonResult<>(200, null,
                new ArrayList<>(Objects.requireNonNull(setOperations.members("contest:" + contestId + ":noEntry"))));
    }

}
