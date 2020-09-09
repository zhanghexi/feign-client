package com.example.consumer.feign.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.example.consumer.feign.EmployeeFeignService;
import com.example.consumer.feign.model.EmployeeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName EmployeeConsumerController
 * @User zhang
 * @Description
 * @Author Lucien
 * @Date 2020/9/3 22:33
 * @Version 1.0
 */
@Log4j2
@RestController
@Api(tags = "测试员工信息接口")
@RequestMapping(value = "/emp")
public class EmployeeConsumerController {

    @Resource
    private EmployeeFeignService employeeFeignService;

    @ApiOperation(value = "调用查询员工信息列表Feign接口的返回值", notes = "Feign接口测试")
    @GetMapping(value = "/queryEmpListByFeignApi/{empName}")
    /*@SentinelResource("queryEmpListByFeignApi")*/
    public List<EmployeeDTO> getEmpInfoByEmpName(@PathVariable("empName") String empName) {
        List<EmployeeDTO> employeeDTOS = employeeFeignService.queryEmpListByFeignApi(empName);
        log.info(JSON.toJSONString(employeeDTOS));
        return employeeDTOS;
    }
}
