package com.jiangfan.mapper;

import com.jiangfan.entity.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @Auther: 江帆
 * @Date: 2020/7/22
 * @Description: com.jiangfan.mapper
 * @version: 1.0
 */
public interface EmployeeMapper {
    @Select(value = "select * from employee where id=#{id}")
    public Employee getEmpById(@Param("id") Integer id);

    @Update(value = "update   employee  set lastName=#{lastName},email=#{email}   where id=#{id}")
    public void updateEmpById(Employee employee);

    @Delete("delete employee   where id=#{id}")
    public void delEmp(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void inertEmp(Employee employee);

}
