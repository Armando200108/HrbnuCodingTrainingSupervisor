package cn.pdteam.controller;

import cn.pdteam.dao.AuthorizationMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class PageController {
    Logger log = LoggerFactory.getLogger(PageController.class);
    @Autowired
    AuthorizationMapper authorizationMapper;

    @RequestMapping("/login")
    public String loginPage(HttpServletRequest request,
                            @RequestParam(value = "error", required = false, defaultValue = "false") Boolean error,
                            Model model) {
        String errorMsg = "Invalid credentials";
        if (error) {
            HttpSession session = request.getSession(false);
            AuthenticationException ex = (AuthenticationException) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
            errorMsg = ex != null ? ex.getMessage() : "Invalid credentials";
            model.addAttribute("errorMsg", errorMsg);
        }
        return "login";
    }

    @RequestMapping("/oauth2/consent")
    public String authorize(@RequestParam String scope,
                            @RequestParam("client_id") String clientId,
                            @RequestParam String state,
                            Authentication authentication, Model model) {
        List<String> scopes = Arrays.stream(scope.split(" ")).toList();
        log.info("/oauth2/consent------>scope:{} client_id:{} state:{} authentication:{}", scope, clientId, state, authentication);
        model.addAttribute("username", authentication.getName());
        model.addAttribute("scopes", authorizationMapper.getScopeDescription(scopes));
        model.addAttribute("clientId", clientId);
        model.addAttribute("clientName", authorizationMapper.getClientName(clientId));
        model.addAttribute("state", state);
        return "authorize";
    }

}
