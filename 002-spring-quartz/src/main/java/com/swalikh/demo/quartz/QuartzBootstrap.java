package com.swalikh.demo.quartz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class QuartzBootstrap {
    public static void main(String[] args){
        SpringApplication.run(QuartzBootstrap.class, args);
    }
}
