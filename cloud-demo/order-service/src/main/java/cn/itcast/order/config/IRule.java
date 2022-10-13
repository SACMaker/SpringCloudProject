package cn.itcast.order.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过写配置类的方式自定义负载均衡策略,注意这里用在消费者端
 */
//@Configuration //此处注释,默认一般是不做修改的
//配置文件方式见此模块配置文件
public class IRule {
    @Bean
    public RandomRule Rule() {
        return new RandomRule();
    }
}
