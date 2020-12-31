package com.example.consumer.feign.controller;

import com.example.consumer.feign.api.RemoteImgCodeService;
import com.example.consumer.feign.http.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ImgCodeConsumerController
 * @User zhang
 * @Description
 * @Author Lucien
 * @Date 2020/11/30 10:48
 * @Version 1.0
 */
@RestController
public class ImgCodeConsumerController {

    @Resource
    private RemoteImgCodeService remoteImgCodeService;

    @GetMapping(value = "/getImgCode")
    public AjaxResult getImgCode() {
        return remoteImgCodeService.getImgCodeByFeignApi();
    }
}