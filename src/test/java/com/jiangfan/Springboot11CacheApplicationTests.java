package com.jiangfan;

import com.jiangfan.entity.Employee;
import com.jiangfan.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.Transient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot11CacheApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisTemplate myRedisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // @Transient
    @Test
    public void contex1tLoads() {
        System.out.println(jdbcTemplate + "------------");
        System.out.println(jdbcTemplate.getDataSource().getClass().getName());
        Employee employee = new Employee();
        employee.setEmail("22@qq.com");
        employee.setGender(0);
        employee.setLastName("jiangfan");
        employeeMapper.inertEmp(employee);
    }

    @Test
    public void test01() {
        System.out.println(employeeMapper.getEmpById(1));
    }

    /**
     * 操作字符串
     */
    @Test
    public void test02() {
        //  stringRedisTemplate.opsForValue().set("hello", "jiangfan");
        String hello = stringRedisTemplate.opsForValue().get("hello");
        System.out.println(hello);
    }

    /**
     * 操作对象
     */
    @Test
    public void test03() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
        redisTemplate.opsForValue().set("AA", empById);
    }

    /**
     * 操作对象  自己实现json序列化
     */
    @Test
    public void test04() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
        myRedisTemplate.opsForValue().set("BB", empById);
    }
}
