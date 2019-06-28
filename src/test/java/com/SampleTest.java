package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author :肖钊容
 * @date :2019-06-19 10:54
 * @description :单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Test
    public void testSelect(){
        System.out.println("hi");
    }
}
