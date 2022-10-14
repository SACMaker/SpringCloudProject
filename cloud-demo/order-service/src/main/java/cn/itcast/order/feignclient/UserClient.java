package cn.itcast.order.feignclient;

import cn.itcast.order.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FeignClient客户端,由它来发送http请求发起PRC调用
 */
//ml:这里的接口有像重写userservice接口
@FeignClient("userservice")
public interface UserClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
