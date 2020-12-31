package com.example.consumer.feign.controller;

import com.example.consumer.feign.api.RemoteUserInfoService;
import com.example.consumer.feign.http.AjaxResult;
import com.example.consumer.feign.model.LoginParamDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName UserInfoConsumerController
 * @User zhang
 * @Description
 * @Author Lucien
 * @Date 2020/11/30 23:04
 * @Version 1.0
 */
@RestController
public class UserInfoConsumerController {

    @Resource
    private RemoteUserInfoService remoteUserInfoService;

    @PostMapping(value = "/doLogin")
    public AjaxResult doLogin(@RequestBody LoginParamDTO loginParamDTO) {
        return remoteUserInfoService.doLogin(loginParamDTO);
    }
}