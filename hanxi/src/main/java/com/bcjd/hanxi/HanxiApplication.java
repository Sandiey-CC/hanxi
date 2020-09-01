package com.bcjd.hanxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.bcjd.hanxi.mapper")
@SpringBootApplication
public class HanxiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanxiApplication.class, args);
    }

}
