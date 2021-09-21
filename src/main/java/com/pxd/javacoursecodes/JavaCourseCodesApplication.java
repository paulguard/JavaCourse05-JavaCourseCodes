package com.pxd.javacoursecodes;

import com.pxd.javacoursecodes.w5.dao.SchoolDao;
import com.pxd.javacoursecodes.w5.dao.SchoolDaoImpl;
import com.pxd.javacoursecodes.w5.service.SchoolService;
import com.pxd.javacoursecodes.w5.service.SchoolServiceImpl;
import com.pxd.javacoursecodes.w7.config.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = "com.pxd")
@Import({DynamicDataSourceConfig.class})
@EnableAspectJAutoProxy
public class JavaCourseCodesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCourseCodesApplication.class, args);
    }

    @Bean
    public SchoolDao schoolDao(){
        return new SchoolDaoImpl();
    }

    @Bean
    public SchoolService schoolService(){
        return new SchoolServiceImpl();
    }
}
