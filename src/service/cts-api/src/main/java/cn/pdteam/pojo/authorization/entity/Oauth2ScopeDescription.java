package cn.pdteam.pojo.authorization.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oauth2ScopeDescription implements Serializable {
    private String scope;

    private String description;

    private static final long serialVersionUID = 1L;
}

