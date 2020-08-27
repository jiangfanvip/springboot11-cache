package com.jiangfan.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 江帆
 * @Date: 2020/7/4
 * @Description: com.jiangfan.springboot08.config
 * @version: 1.0
 */
@Configuration
public class DruidConfig {
    /**
     * 功能描述:注册一个datasource并绑定相关属性值
     *
     * @Auther: 江帆
     * @Date:
     * @Description:
     */
    @Bean
    @ConfigurationProperties(value = "spring.datasource")
    public DataSource druid() {
        return new DruidDataSource();
    }


    /**
     * 功能描述: 注册一个druid 监控的servlet
     *
     * @Auther: 江帆
     * @Date:
     * @Description:
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        Map<String, String> map = new HashMap<>();
        //"/druid/*           /druid/XX 访问都会到这个servlet
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        map.put("loginUsername", "admin");  //指定登录登录名
        map.put("loginPassword", "123456");  //指定密码
        map.put("allow", "");  //默认允许所有访问
     //   map.put("deny","192.168.15.21");  //拒绝谁访问
        servletRegistrationBean.setInitParameters(map);  //指定注册的servlet初始化参数
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        Map<String, String> map = new HashMap<>();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(); //注册过滤器对象
        filterRegistrationBean.setFilter(new WebStatFilter());  //设置过滤器
        map.put("exclusions", "*.js,*.css,/druid/*,/swagger-ui.html#");  //排除一些静态资源不经过此过滤器
        filterRegistrationBean.setInitParameters(map);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*")); //所有请求经过过滤器
        // filterRegistrationBean.setUrlPatterns(Arrays.asList("/mon"));

        return filterRegistrationBean;
    }

}
