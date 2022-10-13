package cn.itcast.order.service;

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


    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.RPC user
        //2.1调用的url
        String url = "http://localhost:8081/user/" + order.getUserId();
        log.info("url:{}", url);
        //2.2发起调用
        User User = restTemplate.getForObject(url, User.class);
        //把RPC查询到的User数据存近Order
        order.setUser(User);
        // 4.返回
        return order;
    }
}
