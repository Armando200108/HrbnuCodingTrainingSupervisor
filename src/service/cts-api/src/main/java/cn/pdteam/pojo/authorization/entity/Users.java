package cn.pdteam.pojo.authorization.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否可用
     */
    private Boolean enabled;

    /**
     * 账户到期日
     */
    private LocalDateTime accountExpirationDate;

    /**
     * 凭据到期日
     */
    private LocalDateTime credentialExpirationDate;

    /**
     * 账户未被锁定
     */
    private Boolean accountNonLocked;

    private static final long serialVersionUID = 1L;
}

