package com.jinguizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 14:32
 **/
@SpringBootApplication
@ServletComponentScan("com.jinguizi.config")
//@EnableScheduling
public class LandingPageApplication {
    public static void main(String[] args) {
        SpringApplication.run(LandingPageApplication.class);
    }
}
