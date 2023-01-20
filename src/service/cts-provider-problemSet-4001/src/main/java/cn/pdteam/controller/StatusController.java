package cn.pdteam.controller;

import cn.pdteam.dao.StatusMapper;
import cn.pdteam.pojo.CommonResult;
import cn.pdteam.pojo.problemSet.entity.Status;
import com.alibaba.cloud.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    StatusMapper statusMapper;

    @GetMapping("/query")
    public CommonResult<List<Status>> queryStatus(@RequestParam Map<String, Object> param) {
        int page = 1;
        int limit = 10;
        String search = null;
        if (!StringUtils.isEmpty((String) param.get("page"))) {
            page = Integer.parseInt((String) param.get("page"));
        }
        if (!StringUtils.isEmpty((String) param.get("limit"))) {
            limit = Integer.parseInt((String) param.get("limit"));
        }
        if (!StringUtils.isEmpty((String) param.get("username"))) {
            search = (String) param.get("username");
        }
        List<Status> statusList = statusMapper.queryStatus(page, limit, search);
        return new CommonResult<>(200, "success", statusList);
    }

    @GetMapping("/query/contest")
    public CommonResult<List<Status>> queryStatusByContestId(@RequestParam Map<String, Object> param) {
        Integer page = 1;
        Integer limit = 10;
        Integer contestId = null;
        String search = null;
        if (!StringUtils.isEmpty((String) param.get("page"))) {
            page = Integer.parseInt((String) param.get("page"));
        }
        if (!StringUtils.isEmpty((String) param.get("limit"))) {
            limit = Integer.parseInt((String) param.get("limit"));
        }
        if (!StringUtils.isEmpty((String) param.get("contestId"))) {
            contestId = Integer.parseInt((String) param.get("contestId"));
        }
        if (!StringUtils.isEmpty((String) param.get("username"))) {
            search = (String) param.get("username");
        }
        List<Status> statusList = statusMapper.queryStatusByContestId(page, limit, search, contestId);
        return new CommonResult<>(200, "success", statusList);
    }

    @PostMapping("/add")
    public CommonResult addStatus(@RequestParam("problemId") Integer problemId,
                                  @RequestParam(value = "contestId", required = false) Integer contestId,
                                  @RequestParam("username") String username,
                                  @RequestParam("language") Integer language) {
        Status status = new Status(0, username, problemId, contestId, 7, 0, 0, 0, language, LocalDateTime.now());
        statusMapper.addStatus(status);
        return new CommonResult<>(200, "success", status);
    }

    @PutMapping("/update")
    public CommonResult<Status> updateStatus(@RequestBody Status status) {
        statusMapper.updateStatus(status);
        return new CommonResult<>(200, "success", statusMapper.queryStatusById(status.getId()));
    }
}
