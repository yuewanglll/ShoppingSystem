package com.hmall.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "hm.auth")
public class AuthProperties {
    //需要拦截的路径
    private List<String> includePaths;
    //不需要拦截的路径
    private List<String> excludePaths;
}
