package com.pxd.javacoursecodes;

import com.pxd.javacoursecodes.w5.entity.School;
import com.pxd.javacoursecodes.w5.entity.Student;
import com.pxd.javacoursecodes.w5.service.SchoolService;
import com.pxd.javacoursecodes.w5.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JavaCourseCodesApplicationTests {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolService schoolService;

    @Test
    public void testGetAllStudents(){

        List<Student> allStudents = studentService.selectAll();
    }

    @Test
    public void testGetAllSchools(){

        List<School> allSchools = schoolService.selectAll();
    }

}
