package cn.itcast.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfig {
    /**
     * 注册RestTemplate用于RPC
     *
     * @return
     */
    @Bean
    //eureka负载均衡
    //负载均衡
    //负载均衡,拦截请求,携带服务名去eureka服务器发现真实的服务ip和端口并根据自身的负载均衡算法去选择实例去调用
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
