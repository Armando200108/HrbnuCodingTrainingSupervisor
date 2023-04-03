package cn.pdteam.controller;

import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.*;

@Controller
public class IndexController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String index(Model model) {
        // 从安全上下文中获取登录信息，返回给model
        Map<String, Object> map = new HashMap<>(2);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        map.put("name", auth.getName());
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.stream().iterator();
        ArrayList<Object> authList = new ArrayList<>();
        while (iterator.hasNext()) {
            authList.add(iterator.next().getAuthority());
        }

        map.put("authorities", authList);
        model.addAttribute("user", JSON.toJSONString(map));
        return "index";
    }

    @GetMapping("/user")
    @ResponseBody
    public Object userInfo(Principal principal){
        return principal;
    }

    @GetMapping("/principal")
    @ResponseBody
    public Object getInfo(){
        return SecurityContextHolder.getContext().getAuthentication().getDetails();
    }
}
