package com.tyh.code;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
//@ActiveProfiles("test")//单元测试
// 走application-test.properties配置文件
//@ActiveProfiles("dev")
public class ApplicationTests {
    @Test
    public void test() {

    }
}
