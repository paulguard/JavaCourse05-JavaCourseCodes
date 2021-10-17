package com.pxd.javacoursecodes;

import com.pxd.javacoursecodes.w8.service.JTAService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class JTAServiceTest {

    @Resource
    private JTAService jtaService;

    @Test
    public void test(){

        try {
            jtaService.insert();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
