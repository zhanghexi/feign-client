package com.example.consumer.feign.controller;

import com.example.consumer.feign.api.NacosConfigConstantFeignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName NacosConstantController
 * @User zhang
 * @Description
 * @Author Lucien
 * @Date 2020/10/15 11:12
 * @Version 1.0
 */
@RestController
@Api(tags = "测试获取Nacos共享变量")
public class NacosConstantController {

    @Resource
    private NacosConfigConstantFeignService nacosConfigConstantFeignService;

    @ApiOperation(value = "获取Nacos共享变量接口的返回值", notes = "Feign接口测试")
    @GetMapping(value = "/getNacosConstant")
    public String getNacosConstant() {
        return nacosConfigConstantFeignService.getNacosConstant();
    }
}