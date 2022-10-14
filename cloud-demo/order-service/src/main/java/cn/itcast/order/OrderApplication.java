package cn.itcast.order;

import cn.itcast.order.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@MapperScan("cn.itcast.order.mapper")
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class)//开启feign功能
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}