package cn.pdteam.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;

/**
 * <p>用户信息接口</p>
 */
@RestController
@RequestMapping("/oauth2")
public class EndPointController {
    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping(value = "/user", produces = "application/json;charset=UTF-8")
    public Authentication oauth2UserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return authentication;
    }

    @GetMapping("/out")
    public void logout(HttpServletRequest request,
                       HttpServletResponse response) {

        // ========== 清理客户端 ===========
        // 清理客户端session
        request.getSession().invalidate();
        // 清理客户端安全上下文
        SecurityContextHolder.clearContext();

        // ========== 清理认证中心 ===========
        // 跳转至认证中心退出页面
        try {
            response.sendRedirect("http://uaa.pdteam.cn:3001/logout");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
