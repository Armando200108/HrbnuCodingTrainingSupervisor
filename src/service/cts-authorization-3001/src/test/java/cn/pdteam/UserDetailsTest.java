package cn.pdteam;

import cn.pdteam.dao.UsersMapper;
import cn.pdteam.pojo.authorization.entity.Role;
import cn.pdteam.pojo.authorization.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserDetailsTest {
    @Autowired
    UsersMapper usersMapper;

    @Test
    void UserObjectTest() {
        Users armando = usersMapper.queryUserByName("Armando");
        List<Role> roleList = usersMapper.queryRolesByUsername("Armando");
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roleList) {
            list.add(new SimpleGrantedAuthority(role.getRole()));
        }
        User user = new User(armando.getUsername(), armando.getPassword(), armando.getEnabled(), armando.getAccountExpirationDate().isAfter(LocalDateTime.now()), armando.getCredentialExpirationDate().isAfter(LocalDateTime.now()), armando.getAccountNonLocked(), list);
        System.out.println(user);
    }
}
