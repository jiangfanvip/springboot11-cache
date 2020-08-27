package com.jiangfan.service;

import com.jiangfan.entity.Employee;
import com.jiangfan.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Auther: 江帆
 * @Date: 2020/7/22
 * @Description: com.jiangfan.service
 * @version: 1.0
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = {"emp"}/*keyGenerator = "myKey"*/,key = "#id")
    public Employee getEmployee(Integer id) {
        System.out.println("查询" + id + "几号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
     @CachePut(cacheNames = "emp",key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("update----------"+employee);
        employeeMapper.updateEmpById(employee);
        return employee;
    }
}
