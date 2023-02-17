package cn.pdteam.services;

import cn.pdteam.dao.UsersMapper;
import cn.pdteam.pojo.authorization.entity.Role;
import cn.pdteam.pojo.authorization.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CtsUserDetailsServices implements UserDetailsService {
    @Autowired
    UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userEntity = usersMapper.queryUserByName(username);
        if (userEntity == null) {
            throw new RuntimeException("用户名或密码错误");
        }
        List<Role> roleList = usersMapper.queryRolesByUsername(username);
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roleList) {
            list.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getEnabled(),
                userEntity.getAccountExpirationDate().isAfter(LocalDateTime.now()),
                userEntity.getCredentialExpirationDate().isAfter(LocalDateTime.now()),
                userEntity.getAccountNonLocked(), list);
    }
}
