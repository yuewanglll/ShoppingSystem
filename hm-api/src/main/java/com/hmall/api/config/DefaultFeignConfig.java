package com.hmall.api.config;



import com.hmall.api.fallback.ItemClientFallback;
import com.hmall.common.utils.UserContext;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j
public class DefaultFeignConfig {
    /**
     * feign日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }

    /**
     * feign拦截器，将用户信息传递给下游微服务
     * @return
     */
    @Bean
    public RequestInterceptor userInfoRequestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // 获取登录用户
                Long userId = UserContext.getUser();
                if(userId == null) {
                    // 如果为空则直接跳过
                    return;
                }
                log.info("userId:{}", userId);
                // 如果不为空则放入请求头中，传递给下游微服务
                template.header("user-info", userId.toString());
                log.info("userId已经传递给下游用户{}", userId);
            }
        };
    }

    /**
     * 创建商品服务降级处理类
     * @return
     */
    @Bean
    public ItemClientFallback itemClientFallback(){
        return new ItemClientFallback();
    }

}