package cn.pdteam.controller;

import cn.pdteam.pojo.CommonResult;
import com.alibaba.cloud.commons.lang.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api/problems")
public class ProblemsController {
    private final String problemSetServiceURL = "http://CTS-Provider-ProblemSet";
    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/problemList")
    public CommonResult<?> getProblemList(@RequestParam Map<String, Object> param) {
        int page = 1;
        int limit = 10;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getAuthorities());
        CommonResult<?> result = null;
        if (auth.getAuthorities().contains("ADMIN")) {
            result = restTemplate.getForObject(problemSetServiceURL + "/problems/query/short/all?page=" + page + "&limit=" + limit + "&search=" + search, CommonResult.class);
        } else {
            result = restTemplate.getForObject(problemSetServiceURL + "/problems/query/short/notHiden?page=" + page + "&limit=" + limit + "&search=" + search, CommonResult.class);
        }
        return result;
    }
}
