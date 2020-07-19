package com.will.first.service;

import com.will.first.domain.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> queryAllUsers();

    UserInfo getUserInfoById(Long id);


}
