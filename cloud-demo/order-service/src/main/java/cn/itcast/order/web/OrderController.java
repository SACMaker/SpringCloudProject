package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @SentinelResource("hot")//热点参数限流,包括全局和热点
    @GetMapping("/{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId,
                                    @RequestHeader(value = "origin", required = false) String origin) {
        log.info("origin:{}", origin);
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }

    /**
     * 更新订单状态
     *
     * @return
     */
    @GetMapping("/update")
    public String updateOrder() {
        return "更新订单成功";
    }

    /**
     * 查询订单,查询商品
     *
     * @return
     */
    @GetMapping("/query")
    public String queryOrder() {
        // 查询商品
        orderService.queryGoods();
        // 查询订单
        System.out.println("查询订单");
        return "查询订单成功";
    }

    /**
     * 新增订单，查询商品
     *
     * @return
     */
    @GetMapping("/save")
    public String saveOrder() {
        // 查询商品
        orderService.queryGoods();
        // 查询订单
        System.err.println("新增订单");
        return "新增订单成功";
    }
}
