package com.will.first.service.impl;

import com.will.first.dao.UserInfoMapper;
import com.will.first.domain.UserInfo;
import com.will.first.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

//    private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> queryAllUsers() {
        log.info("test");

        return userInfoMapper.selectAll();
    }
}
