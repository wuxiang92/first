package com.will.first.controller;

import com.will.first.service.util.RedisLockUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "will")
public class Hello {

    @Resource
    RedisLockUtil redisLockUtil;

    @RequestMapping(value = "hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "testLock")
    @ResponseBody
    public String testLock(){

        String value = String.valueOf(System.currentTimeMillis());
        Long lock = redisLockUtil.lock("lock", value, "100");
        System.out.println(lock);
        Long unlock = redisLockUtil.unlock("lock", value);
        System.out.println(unlock);

        return "hello";
    }


}
