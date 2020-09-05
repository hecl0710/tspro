package com.venus.tspro.controller;

import com.venus.tspro.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class LoginController {

    @RequestMapping("login")
    public String indexHandle(){
        return "page/login";
    }

    @RequestMapping("index")
    public String loginHandle(@RequestBody SysUser sysUser){
        log.info("登录请求：{}，{}", sysUser.getUserName(),sysUser.getPassword());
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUserName(),sysUser.getPassword());
//        subject.login(token);
//        log.info("身份验证成功");
        return "page/index";
    }

}
