package com.alarming.manage.dao;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.objectdata.Major;
import com.alarming.manage.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author GUO
 * @Classname MajorDaoTest
 * @Description TODO
 * @Date 2021/4/5 15:02
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MajorDaoTest {

    @Autowired
    private MajorDao majorDao;
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    @Transactional
    public void testFindById(){
        Major major = majorDao.getOne(1);
        System.out.println(major.toString());
    }
    @Test
    public void testFindByName(){
        Major major = majorDao.findByName("软件工程");
        log.info(String.valueOf(major));
    }

    @Test
    public void testFindByDepartment(){
        Department department = departmentDao.getOne(3);
//        Department department = new Department();
        List<Major> majorList = majorDao.findByDepartment(department);
        log.info(majorList.toString());
    }
    @Test
    public void testSaveMajor(){
//        Department department = departmentDao.getOne(2);
        /**
         * 配置了专业到院系的关系(多对一)
         *      只发生两条insert语句
         *     由于配置了联系人到客户的映射关系(多对一)
         */
        Major major = new Major();
        major.setName("无人机");
        major.setCreateTime(DateUtil.ToString());
        majorDao.save(major);
    }
    @Test
    public void testDelMajor(){
        Integer majorNum = majorDao.findMajorNum(3);
        log.info(String.valueOf(majorNum));
    }
    @Test
    public void testFindAll(){
        List<Major> majorList = majorDao.findAll();
        System.out.println(majorList.toString());
    }
}