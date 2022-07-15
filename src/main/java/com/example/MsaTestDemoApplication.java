package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@MapperScan(basePackages = "com.example.resources.mapper")
public class MsaTestDemoApplication {

    //注意：新创建的类一定要位于 Application 同级目录或者下级目录，否则 SpringBoot 加载不到。
    public static void main(String[] args) {
        SpringApplication.run(MsaTestDemoApplication.class, args);
    }

}
