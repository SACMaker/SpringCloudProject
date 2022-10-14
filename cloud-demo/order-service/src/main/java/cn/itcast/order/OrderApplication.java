package cn.itcast.order;

import cn.itcast.feignapi.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("cn.itcast.order.mapper")
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class, basePackages = "cn.itcast.feignapi.feignclients")
//开启oepnfeign功能
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}