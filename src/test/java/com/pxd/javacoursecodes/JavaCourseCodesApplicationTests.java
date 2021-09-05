package com.pxd.javacoursecodes;

import com.pxd.javacoursecodes.w5.entity.Class;
import com.pxd.javacoursecodes.w5.entity.Student;
import com.pxd.javacoursecodes.w5.service.ClassService;
import com.pxd.javacoursecodes.w5.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(locations = {
        "classpath*:springbean.xml"
})
class JavaCourseCodesApplicationTests {

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentService studentService;

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){

        List<Class> allClasses = classService.getAll();
    }

    @Test
    public void test2(){

        List<Student> allStudents = studentService.selectAll();
    }

}
