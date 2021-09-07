package com.pxd.javacoursecodes;

import com.example.pxdstarter.service.DataService;
import com.pxd.javacoursecodes.w5.entity.School;
import com.pxd.javacoursecodes.w5.entity.Student;
import com.pxd.javacoursecodes.w5.service.SchoolService;
import com.pxd.javacoursecodes.w5.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class JavaCourseCodesApplicationTests {

    @Resource
    private StudentService studentService;

    @Resource
    private SchoolService schoolService;

    @Resource
    private DataService dataService;

    @Test
    public void testGetAllStudents(){

        List<Student> allStudents = studentService.selectAll();
    }

    @Test
    public void testGetAllSchools(){

        List<School> allSchools = schoolService.selectAll();
    }

    @Test
    public void testGetSchoolName(){

        String shoolName = dataService.getSchoolName();
        System.out.println(shoolName);
    }

    @Test
    public void testGetSchoolName2(){

        String shoolName = schoolService.getSchoolName();
        System.out.println(shoolName);
    }
}
