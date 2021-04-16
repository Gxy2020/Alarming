package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Counsellor;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.vo.CounsellorVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GUO
 * @Classname CounsellorDaoTest
 * @Description TODO
 * @Date 2021/4/8 21:36
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CounsellorDaoTest {
    @Autowired
    private  CounsellorDao counsellorDao;
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void findAll(){
        List<Counsellor> list = counsellorDao.findAll();
        log.info(list.toString());
    }
    @Test
    public void testSex(){
        List<Counsellor> list = counsellorDao.findAll();
        List counsellorVOList=new ArrayList();
//        for (Counsellor item:list){
//            CounsellorVO counsellorVO = new CounsellorVO();
//            counsellorVO.setId(item.getId());
//            counsellorVO.setUser(item.getUser());
//            counsellorVO.setPassword(item.getPassword());
//            counsellorVO.setUsername(item.getUsername());
//            counsellorVO.setSex(item.getSex());
//            counsellorVO.setDepartmentName(item.getDepartment().getName());
//            counsellorVO.setPhone(item.getPhone());
//            counsellorVO.setEmail(item.getEmail());
//            counsellorVO.setCreateTime(item.getCreateTime());
//            counsellorVOList.add(counsellorVO);
//        }
        list.stream().forEach(item->{
            CounsellorVO counsellorVO = new CounsellorVO();
            counsellorVO.setId(item.getId());
            counsellorVO.setUser(item.getUser());
            counsellorVO.setPassword(item.getPassword());
            counsellorVO.setUsername(item.getUsername());
            counsellorVO.setSex(item.getSex());
            counsellorVO.setDepartmentName(item.getDepartment().getName());
            counsellorVO.setPhone(item.getPhone());
            counsellorVO.setEmail(item.getEmail());
            counsellorVO.setCreateTime(item.getCreateTime());
            counsellorVOList.add(counsellorVO);
        });
        log.info(String.valueOf(counsellorVOList));
    }
    @Test
    public void testSave(){
        Counsellor counsellor = new Counsellor();
        counsellor.setUser("20210414");
        counsellor.setPassword("123123");
        counsellor.setUsername("王大虎");
//        Department one = departmentDao.getOne(1);
//        counsellor.setDepartment(one);
        counsellorDao.save(counsellor);
    }
    @Test
    public void findByUser(){
        Counsellor counsellor = counsellorDao.findByUser("20210413");
        log.info(String.valueOf(counsellor));
    }
}