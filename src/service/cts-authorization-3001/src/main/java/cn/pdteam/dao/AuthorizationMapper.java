package cn.pdteam.dao;

import cn.pdteam.pojo.authorization.entity.Oauth2ScopeDescription;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
public interface AuthorizationMapper {
    String getClientName(String clientId);

    @MapKey("scope")
    Map<String, Oauth2ScopeDescription> getScopeDescription(List<String> scopes);
}
