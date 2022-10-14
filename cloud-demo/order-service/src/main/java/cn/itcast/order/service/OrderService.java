package cn.itcast.order.service;

import cn.itcast.order.feignclient.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;


    //@Autowired
    //private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.RPC user
        //2.1原始写法调用的url
        //String url = "http://localhost:8081/user/" + order.getUserId();
        //2.1在eureka注册中心服务器进行服务的拉取
        //按照服务名字进行拉取的
        //RestTemplate写法
        //String url = "http://userservice/user/" + order.getUserId();
        //2.2发起调用
        //User User = restTemplate.getForObject(url, User.class);
        //FeignClient写法
        User User = userClient.findById(order.getUserId());
        // log.info("url:{}", url);
        //把RPC查询到的User数据存近Order
        order.setUser(User);
        // 4.返回
        return order;
    }
}
