package cn.pdteam.controller;

import cn.pdteam.dao.ContestInfoMapper;
import cn.pdteam.pojo.CommonResponse;
import cn.pdteam.pojo.CommonResult;
import cn.pdteam.pojo.PageResult;
import cn.pdteam.pojo.contest.ContestInfoDetails;
import cn.pdteam.pojo.contest.QueryListOptions;
import cn.pdteam.pojo.contest.ShortContestInfo;
import cn.pdteam.pojo.contest.entity.ContestInfo;
import cn.pdteam.pojo.contest.request.AddContestRequest;
import cn.pdteam.pojo.problemSet.ShortProblemInfo;
import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/contest")
public class ContestController {
    @Autowired
    ContestInfoMapper contestInfoMapper;
    @Resource
    RedisTemplate<String, Object> redisTemplateForSerializableObjects;

    @Resource(name = "lbRestTemplate")
    RestTemplate restTemplate;

    static Logger logger = LoggerFactory.getLogger(ContestController.class);

    @PostMapping("/add")
    @Transactional
    public CommonResponse addContest(@RequestBody @Validated AddContestRequest request) {
        ContestInfo contestInfo = new ContestInfo(UUID.randomUUID().toString(), request.getLogo(), request.getName(), request.getIntroduction(),
                request.getRegistrationStartTime(), request.getRegistrationEndTime(), request.getContestStartTime(), request.getContestEndTime(),
                request.getNotice(), "Armando");
        contestInfoMapper.addContest(contestInfo);
        contestInfoMapper.addContestProblem(contestInfo.getId(), request.getProblems());
        return new CommonResponse(200, true, contestInfo.getId());
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public CommonResponse deleteContest(@PathVariable("id") String id) {
        if (!contestInfoMapper.checkContestExist(id)) {
            throw new IllegalArgumentException("该比赛不存在");
        }
        Set<String> keys = redisTemplateForSerializableObjects.keys("contest:" + id + "*");
        redisTemplateForSerializableObjects.setEnableTransactionSupport(true);
        try {
            redisTemplateForSerializableObjects.multi();
            if (keys != null) {
                for (String key : keys) {
                    redisTemplateForSerializableObjects.delete(key);
                    logger.info("在redis中找到了key为：" + key + "的数据！");
                }
            }
            contestInfoMapper.removeContest(id);
            redisTemplateForSerializableObjects.exec();
            logger.info("已删除redis中正则表达式为：" + "contest:" + id + "*" + "的数据，共" + (keys != null ? keys.size() : 0) + "条");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("因" + e.getClass().getName() + ":" + e.getMessage() + "，未能删除redis中数据，已中断事务。");
            redisTemplateForSerializableObjects.discard();
            return new CommonResponse(500, false, e.getMessage());
        }
        return new CommonResponse(200, true, null);
    }

    @PutMapping("/update/info")
    public CommonResult<ContestInfo> updateContestInfo(@Validated @RequestBody ContestInfo contestInfo) {
        if (contestInfo.getRegistrationEndTime().isBefore(contestInfo.getRegistrationStartTime())) {
            throw new IllegalArgumentException("报名结束时间必须在报名开始时间之后。");
        }
        if (contestInfo.getContestEndTime().isBefore(contestInfo.getContestStartTime())) {
            throw new IllegalArgumentException("比赛结束时间必须在比赛开始时间之后。");
        }
        if (contestInfo.getContestStartTime().isBefore(contestInfo.getRegistrationEndTime())) {
            throw new IllegalArgumentException("比赛开始时间必须在报名结束时间之后！");
        }
        contestInfoMapper.updateContestInfo(contestInfo);
        return new CommonResult<>(200, "success!", null);
    }

    @PutMapping("/update/problems/{contestId}")
    @Transactional
    public CommonResult<List<Integer>> updateContestProblems(@PathVariable("contestId") String contestId,
                                                             @RequestBody List<Integer> problems) {
        contestInfoMapper.removeContestProblems(contestId);
        contestInfoMapper.addContestProblem(contestId, problems);
        return new CommonResult<>(200, "success!", problems);
    }

    @GetMapping("/query/list")
    public CommonResult<PageResult<ShortContestInfo>> queryContestInfoShortList(@RequestParam Map<String, Object> param) {
        if (StringUtils.isEmpty((String) param.get("page"))) {
            param.put("page", 1);
        }
        if (StringUtils.isEmpty((String) param.get("limit"))) {
            param.put("limit", 50);
        }
        String json = JSON.toJSONString(param);
        QueryListOptions options = JSON.parseObject(json, QueryListOptions.class);
        return new CommonResult<>(200, "success!", new PageResult<>(contestInfoMapper.queryContestListCount(options),
                options.limit(), options.page(), contestInfoMapper.queryContestList(options)));
    }

    @GetMapping("/query/contest/{contestId}")
    public CommonResult<ContestInfoDetails> queryContestInfoDetails(@PathVariable("contestId") String contestId) {
        ContestInfo contestInfo = contestInfoMapper.queryContestInfo(contestId);
        List<Integer> problemsIdList = contestInfoMapper.queryContestProblems(contestId);
        List<ShortProblemInfo> shortProblemInfoList = new ArrayList<>();
        for (Integer problemId : problemsIdList) {
            CommonResult commonResult = restTemplate.getForObject("http://CTS-Provider-ProblemSet/problems/query/short/" + problemId, CommonResult.class);
            if (commonResult != null && commonResult.getCode() == 200) {
                String json = JSON.toJSONString(commonResult.getData());
                shortProblemInfoList.add(JSON.parseObject(json,ShortProblemInfo.class));
            }
        }
        return new CommonResult<>(200, "success", new ContestInfoDetails(contestInfo, shortProblemInfoList));
    }
}
