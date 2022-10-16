package cn.itcast.order.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@Component
public class HeaderOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        log.debug("进来了");
        // 1.获取请求头
        String origin = request.getHeader("origin");
        log.debug(origin+"----------------1");
        // 2.非空判断
        if (StringUtils.isEmpty(origin)) {
            origin = "blank";
            log.debug(origin+"-----------------2");
        }
        log.debug(origin+"--------------------3");
        return origin;
    }
}
