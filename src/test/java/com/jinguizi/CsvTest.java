package com.jinguizi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-02-01 18:32
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CsvTest {

    @Test
    public void test01(){
        /*CSVWriter writer= null;
        try {
            writer = new CSVWriter(
                    new OutputStreamWriter(new FileOutputStream("D://asdas.csv"),"utf-8"),
                    '\t',CSVWriter.NO_QUOTE_CHARACTER);
            String[] strings={"第一行","001","sds"};
            writer.writeNext(strings);
            writer.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
