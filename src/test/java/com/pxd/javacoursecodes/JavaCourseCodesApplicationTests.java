package com.pxd.javacoursecodes;

import com.pxd.javacoursecodes.w5.entity.School;
import com.pxd.javacoursecodes.w5.entity.Student;
import com.pxd.javacoursecodes.w5.service.SchoolService;
import com.pxd.javacoursecodes.w5.service.StudentService;
import com.pxd.javacoursecodes.w7.dao.SohMapper;
import com.pxd.javacoursecodes.w7.entity.Soh;
import com.pxd.javacoursecodes.w7.service.SohService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@SpringBootTest
//@ComponentScan(value = "com.pxd.javacoursecodes.w7.*")
class JavaCourseCodesApplicationTests {

    private int NUMER_PER_TIMES = 20000;

    @Resource
    private StudentService studentService;

    @Resource
    private SchoolService schoolService;

    @Resource
    private SohMapper sohMapper;

    @Resource
    private SohService sohService;

    @Test
    public void testGetAllStudents(){

        List<Student> allStudents = studentService.selectAll();
    }

    @Test
    public void testGetAllSchools(){

        List<School> allSchools = schoolService.selectAll();
    }

    @Test
    public void test() throws InterruptedException, BrokenBarrierException {

        long t1 = System.currentTimeMillis();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(11);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread t = new Thread(() -> {

                for (int j = 0; j < 5; j++) {
                    int rlt = insertBatch(finalI);
                    System.out.println(rlt);
                }

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }

        cyclicBarrier.await();

        long t2 = System.currentTimeMillis();

        System.out.println("花费时间:"+(t2-t1) + "ms");

    }

    /**
     * 顺序逐条插入10000条
     */
    @Test
    public void testSerialInsert() {

        long t1 = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            int rlt = insert(i);
            System.out.println(rlt);
        }

        long t2 = System.currentTimeMillis();

        System.out.println("花费时间:"+(t2-t1) + "ms");

    }

    /**
     * 顺序批量插入
     */
    @Test
    public void testSerialBatchInsert() {

        long t1 = System.currentTimeMillis();

        for (int i = 0; i < 1; i++) {
            int rlt = insertBatch(i);
            System.out.println(rlt);
        }

        long t2 = System.currentTimeMillis();

        System.out.println("花费时间:"+(t2-t1) + "ms");

    }

    /**
     * 顺序批量插入
     */
    @Test
    public void deleteFromSharding() {

        int i = sohMapper.deleteById(649033619331330113L);
        System.out.println(i);

    }

    @Test
    public void getByIdSharding() {

        Soh soh = sohMapper.getById(649033619331330114L);
        System.out.println(soh.getCode());

    }

    @Test
    public void updateBySharding() {

        Soh soh = sohMapper.getById(649033619331330114L);
        soh.setCode("1010101010110101099999");

        sohMapper.updateCode(soh);

        Soh rltSoh = sohMapper.getById(soh.getId());

        System.out.println(rltSoh.getCode());

    }



    private int insertBatch(int index) {
        List<Soh> totalList = new ArrayList<>();
        for (int i = index * NUMER_PER_TIMES; i < (index + 1 ) * NUMER_PER_TIMES; i++) {

            Soh soh = new Soh();
            soh.setCreatorId(1L);
            soh.setCreateTime(new Date());
            soh.setCode("2021-9-20-"+System.currentTimeMillis()+ Math.random());
            soh.setStatus("222");
            soh.setBuyerName("buyerName");
            soh.setBuyerProvince("浙江省");
            soh.setBuyerCity("杭州市");
            soh.setBuyerCounty("拱墅区");
            soh.setBuyerDetailAddr("贡院9幢406室");
            soh.setUserId((long)(i%10));

            totalList.add(soh);
        }

        int result = 0;
        try {
            result = sohMapper.addSingleSohBatch(totalList);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @Test
    public void testSelectReadOnly(){

        Soh soh = sohService.getById(3938811L);
        System.out.println(soh.getCode());

    }

    private int insert(int i) {

        Soh soh = new Soh();
        soh.setCreatorId(1L);
        soh.setCreateTime(new Date());
        soh.setCode("2021-9-20-"+System.currentTimeMillis()+ Math.random());
        soh.setStatus("222");
        soh.setBuyerName("buyerName");
        soh.setBuyerProvince("浙江省");
        soh.setBuyerCity("杭州市");
        soh.setBuyerCounty("拱墅区");
        soh.setBuyerDetailAddr("贡院9幢406室");
        soh.setUserId((long)(i%10));

        int result = 0;
        try {
            result = sohMapper.addSingleSoh(soh);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
