package cn.pdteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
    @Autowired
    RegisteredClientRepository registeredClientRepository;

    @RequestMapping("/callback")
    public String callback(@RequestParam("code") String code) {
        return "您的授权码是==>" + code;
    }

    @RequestMapping("/rc/{client_id}")
    public RegisteredClient rc(@PathVariable("client_id") String clientId) {
        return registeredClientRepository.findByClientId(clientId);
    }
}
