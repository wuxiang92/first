package com.will.first.service.impl;

import com.will.first.dao.UserInfoMapper;
import com.will.first.domain.UserInfo;
import com.will.first.service.UserInfoService;
import com.will.first.service.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;

    @Resource(name = "redisTemplate")
    RedisTemplate redisTemplate;

    @Override
    public List<UserInfo> queryAllUsers() {
        log.info("test");
        if(redisTemplate.hasKey("allUsers")){
            log.info("redisTemplate - get");
            return JsonUtil.stringToObjectList(UserInfo.class, redisTemplate.opsForValue().get("allUsers").toString());
        } else {
            List<UserInfo> userInfoList = userInfoMapper.selectAll();
            log.info("redisTemplate - set");
            redisTemplate.opsForValue().set("allUsers", JsonUtil.toString(userInfoList));
            return userInfoList;
        }
    }

    @Override
    @Cacheable(value = "userInfoCache")
    public UserInfo getUserInfoById(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
