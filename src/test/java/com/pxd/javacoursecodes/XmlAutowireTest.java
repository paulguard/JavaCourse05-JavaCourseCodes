package com.pxd.javacoursecodes;

import com.pxd.javacoursecodes.w5.entity.Clazz;
import com.pxd.javacoursecodes.w5.service.ClassService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

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

        List<Clazz> allClazzes = classService.getAll();
    }

    @Test
    public void testGetOneClass(){

        List<Clazz> allClazzes = classService.getClass(1L);

        for (Clazz curClazz : allClazzes) {
            System.out.println(curClazz);
        }
    }

    @Test
    public void testDeleteClass(){

        int result = classService.deleteClass(1L);
        System.out.println(result);
    }

    @Test
    public void testUpdateClass(){

        Clazz clazz = new Clazz();
        clazz.setId(1L);
        clazz.setName("三年B班");

        int result = classService.updateClass(clazz);
        System.out.println(result);
    }

}
