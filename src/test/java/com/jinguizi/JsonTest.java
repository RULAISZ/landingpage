package com.jinguizi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 17:30
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class JsonTest {

    @Test
    public void test01(){
        String[] split = "upload.csv".split("\\.");
        System.out.println(Arrays.toString(split));
    }



}
