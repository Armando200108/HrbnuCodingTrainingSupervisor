package cn.pdteam.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "jwt")
@EnableConfigurationProperties(JwtProperties.class)
public class JwtProperties {

    /**
     * 证书信息（内部静态类）
     * 证书存放位置...
     */
    private CertInfo certInfo;

    /**
     * 证书声明（内部静态类）
     * 发证方...
     */
    private Claims claims;

    @Data
    public static class Claims {
        /**
         * 发证方
         */
        private String issuer;
        /**
         * 有效期
         */
        private Integer expiresAt;
    }

    @Data
    public static class CertInfo {
        /**
         * 证书存放位置
         */
        private String publicKeyLocation;
    }
}
