package com.will.first.service.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.will.first.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static final String toString(Object object){
        String string = null;
        try{
            string = objectMapper.writeValueAsString(object);
        }catch (Exception e){
            log.error("-toString(),Exception ", e);
        }
        return string;
    }

    public static final <T> T stringToObject(Class<T> t, String s){
        T object = null;
        try{
            object = objectMapper.readValue(s, t);
        }catch (Exception e){
            log.error("-stringToObject(),Exception ", e);
        }
        return object;
    }

    public static final <T> List<T> stringToObjectList(Class<T> t, String s){
        List<T> objectList = null;
        try{
            objectList = objectMapper.readValue(s, new TypeReference<List<T>>(){});
        }catch (Exception e){
            log.error("-stringToObjectList(),Exception ", e);
        }
        return objectList;
    }

    public static void main(String[] args) {
        var userInfo = new UserInfo();
        userInfo.setName("test");
        userInfo.setIdCard("12312312");
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(userInfo);
        userInfoList.add(userInfo);
        try {
            System.out.println(objectMapper.writeValueAsString(userInfoList));
            List<UserInfo> userInfoList1 = stringToObjectList(UserInfo.class, objectMapper.writeValueAsString(userInfoList));
            userInfo.setName("test2");
            System.out.println(objectMapper.writeValueAsString(userInfoList));
            System.out.println(userInfoList1);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
