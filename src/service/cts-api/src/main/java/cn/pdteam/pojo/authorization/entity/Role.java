package cn.pdteam.pojo.authorization.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    /**
     * uuid
     */
    private String id;

    /**
     * role_name_en_US
     */
    private String role;

    /**
     * role_name_zh_CN
     */
    private String roleZh;

    private static final long serialVersionUID = 1L;
}

