package cn.pdteam.dao;

import cn.pdteam.pojo.authorization.entity.Role;
import cn.pdteam.pojo.authorization.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UsersMapper {
    Users queryUserByName(String username);

    List<Role> queryRolesByUsername(String username);
}
