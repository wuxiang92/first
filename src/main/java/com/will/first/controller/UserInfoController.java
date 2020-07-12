package com.will.first.controller;

import com.will.first.domain.UserInfo;
import com.will.first.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
