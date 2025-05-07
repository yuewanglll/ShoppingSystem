package com.hmall.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import java.time.Duration;

@Data
@ConfigurationProperties(prefix = "hm.jwt")
public class JwtProperties {
    //密钥地址
    private Resource location;
    //密钥文件密码
    private String password;
    //秘钥别名
    private String alias;
    //登录有效期
    private Duration tokenTTL = Duration.ofMinutes(10);
}
