package com.jiangfan.controller;

import com.jiangfan.entity.Employee;
import com.jiangfan.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 江帆
 * @Date: 2020/7/22
 * @Description: com.jiangfan.controller
 * @version: 1.0
 */
@Api(value = "缓存controller", tags = "缓存controller")

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmp/{id}")
    @ApiOperation(value = "用户缓存查询接口", notes = "用户缓存查询接口")
    public Employee getEmp(@PathVariable("id") Integer id) {

        return employeeService.getEmployee(id);
    }

    @PostMapping("/upEmp")
    @ApiOperation(value = "用户更新接口", notes = "用户更新接口")
    public Employee upEmp(@RequestBody  Employee employee) {

        Employee employee1 = employeeService.updateEmp(employee);
        return employee;
    }


}
