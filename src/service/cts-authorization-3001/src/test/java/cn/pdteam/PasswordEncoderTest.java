package cn.pdteam;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {
    @Test
    void BCryptTest(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
