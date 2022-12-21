package cn.pdteam.controller;

import cn.pdteam.dao.ProblemsMapper;
import cn.pdteam.dao.TagsMapper;
import cn.pdteam.pojo.CommonResult;
import cn.pdteam.pojo.problemSet.ProblemInfoDetails;
import cn.pdteam.pojo.problemSet.ShortProblemInfo;
import cn.pdteam.pojo.problemSet.entity.Problem;
import cn.pdteam.pojo.problemSet.request.AddProblemRequest;
import com.alibaba.cloud.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/problems")
public class ProblemsController {
    @Autowired
    ProblemsMapper problemsMapper;
    @Autowired
    TagsMapper tagsMapper;

    @GetMapping("/query/short/notHiden")
    public CommonResult queryShortList(@RequestParam Map<String, Object> param) {
        CommonResult<List<ShortProblemInfo>> result;
        int page = 1;
        int limit = 10;
        String search = null;
        if (!StringUtils.isEmpty((String) param.get("page"))) {
            page = Integer.parseInt((String) param.get("page"));
        }
        if (!StringUtils.isEmpty((String) param.get("limit"))) {
            limit = Integer.parseInt((String) param.get("limit"));
        }
        if (!StringUtils.isEmpty((String) param.get("search"))) {
            search = (String) param.get("search");
        }
        try {
            List<ShortProblemInfo> infoList = problemsMapper.queryNotHiddenShortProblemsInfo(page, limit, search);
            for (ShortProblemInfo info : infoList) {
                info.setTagsList(problemsMapper.queryTagsByProblemId(info.getId()));
            }
            result = new CommonResult<>(200, null, infoList);
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new CommonResult<>(500, ex.getMessage(), null);
        }
        return result;
    }

    @GetMapping("/query/short/all")
    public CommonResult queryShortListNotHidden(@RequestParam Map<String, Object> param) {
        CommonResult<List<ShortProblemInfo>> result;
        int page = 1;
        int limit = 10;
        String search = null;
        if (!StringUtils.isEmpty((String) param.get("page"))) {
            page = Integer.parseInt((String) param.get("page"));
        }
        if (!StringUtils.isEmpty((String) param.get("limit"))) {
            limit = Integer.parseInt((String) param.get("limit"));
        }
        if (!StringUtils.isEmpty((String) param.get("search"))) {
            search = (String) param.get("search");
        }
        try {
            List<ShortProblemInfo> infoList = problemsMapper.queryAllShortProblemsInfo(page, limit, search);
            for (ShortProblemInfo info : infoList) {
                info.setTagsList(problemsMapper.queryTagsByProblemId(info.getId()));
            }
            result = new CommonResult<>(200, null, infoList);
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new CommonResult<>(500, ex.getMessage(), null);
        }
        return result;
    }

    @GetMapping("/query/details/{id}")
    public CommonResult<ProblemInfoDetails> queryProblemInfoDetails(@PathVariable("id") Integer id) {
        Problem problem = problemsMapper.queryProblemInfoById(id);
        if (problem == null) {
            throw new IllegalArgumentException("Could not find this problem");
        }
        List<String> tags = problemsMapper.queryTagsByProblemId(problem.getId());
        return new CommonResult<>(200, null, new ProblemInfoDetails(problem, tags));
    }

    @PostMapping("/add")
    @Transactional
    public CommonResult<ProblemInfoDetails> addProblem(@RequestBody AddProblemRequest request) {
        problemsMapper.addProblem(request.getProblem());
        problemsMapper.addPtBind(request.getProblem().getId(), request.getTagIdList());
        return new CommonResult<>(200, "success",
                new ProblemInfoDetails(problemsMapper.queryProblemInfoById(request.getProblem().getId()),
                        problemsMapper.queryTagsByProblemId(request.getProblem().getId())));
    }

    @DeleteMapping("/remove/{id}")
    @Transactional
    public CommonResult removeProblem(@PathVariable("id") Integer id) {
        try {
            problemsMapper.removeProblemById(id);
            return new CommonResult<Integer>(200, null, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new CommonResult<Integer>(500, ex.getMessage(), null);
        }
    }

    @PutMapping("/update/problem")
    public CommonResult<Integer> updateProblemInfo(@RequestBody Problem problem) {
        int i = problemsMapper.updateProblem(problem);
        if (i == 0) {
            throw new IllegalArgumentException("Could not find this problem");
        }
        return new CommonResult<>(200, "success", i);
    }

    @PutMapping("/update/tags/{problemId}")
    @Transactional
    public CommonResult<Integer> updateProblemTags(@PathVariable("problemId") Integer problemId,
                                                   @RequestBody List<Integer> tagsId) {
        problemsMapper.removeProblemAllTags(problemId);
        problemsMapper.addPtBind(problemId, tagsId);
        return new CommonResult<>(200, "success");
    }


}
