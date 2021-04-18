package com.alarming.manage.service.impl;

import com.alarming.manage.dao.SClassDao;
import com.alarming.manage.objectdata.SClass;
import com.alarming.manage.service.SClassService;
import com.alarming.manage.vo.ClassVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname SClassServiceImplTest
 * @Description TODO
 * @Date 2021/4/14 18:34
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class sClassServiceImplTest {
    @Autowired
    private SClassService sClassService;
    @Autowired
    private SClassDao sClassDao;

    @Test
    public void findAll() {
    }

    @Test
    public void findByDepartment() {
        List<SClass> classList = sClassService.findByDepartment(3);
        log.info(classList.toString());
    }
    @Test
    public void findByDepartmentIdOrMajorId(){
        List<ClassVO> list = sClassService.findByDepartmentIdOrMajorId(0, 1);
        log.info(String.valueOf(list));
    }
    @Test
    public void findByMajorId(){
        List<Map<String, Object>> byMajorId = sClassDao.findByMajorId(2);
        log.info(byMajorId.toString());

    }
}