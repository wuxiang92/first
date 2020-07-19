package com.will.first.controller;

import com.will.first.domain.UserInfo;
import com.will.first.service.UserInfoService;
import com.will.first.service.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "will")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "user-table")
    public String userTable(Model model){
        List<UserInfo> userInfoList = userInfoService.queryAllUsers();
        model.addAttribute("userInfoList", userInfoList);
        return "user-table";
    }

    @RequestMapping(value = "get-user-by-id")
    @ResponseBody
    public String getUserInfoById(Long id){
        UserInfo userInfo = userInfoService.getUserInfoById(id);
        return JsonUtil.toString(userInfo);
    }

}
