package cn.itcast.user.web;

import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${pattern.dateformat}")//占位符形式拿值
    private String dateformat;

    @GetMapping("now")
    public String now() {
        log.info("dateformat:{}", dateformat);
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
    }
}