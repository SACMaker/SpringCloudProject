package cn.itcast.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * Openfeign日志级别的配置类,配置文件写法见配置文件
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level feignLogLevel() {
        return Logger.Level.BASIC; // 日志级别为BASIC
    }
}
