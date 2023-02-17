package cn.pdteam;

import cn.pdteam.dao.AuthorizationMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class AuthorizationTest {
    @Autowired
    AuthorizationMapper mapper;

    @Test
    void scopesDescriptionTest() {
        String scope = "read write";
        List<String> scopes = Arrays.stream(scope.split(" ")).toList();
        System.out.println(mapper.getScopeDescription(scopes));
    }
}
