package com.pxd.javacoursecodes;

import com.pxd.javacoursecodes.w5.service.ClassService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.pxd.javacoursecodes.w5.entity.Class;

import java.util.List;

@SpringBootTest
@ContextConfiguration(locations = {
        "classpath*:springbean.xml"
})
public class XmlAutowireTest {

    @Autowired
    private ClassService classService;

    @Test
    public void testGetAllClass(){

        List<Class> allClasses = classService.getAll();
    }

}
