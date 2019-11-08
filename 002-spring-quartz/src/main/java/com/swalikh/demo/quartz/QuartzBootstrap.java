package com.swalikh.demo.quartz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.swalikh.kernel.exception","com.swalikh.demo.quartz"})

public class QuartzBootstrap {
    public static void main(String[] args){
        SpringApplication.run(QuartzBootstrap.class, args);
    }
}
