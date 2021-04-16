package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Major;
import com.alarming.manage.objectdata.SClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GUO
 * @Classname ClassDaoTest
 * @Description TODO
 * @Date 2021/4/5 23:30
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SClassDaoTest {
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private SClassDao sClassDao;
    @Autowired
    private TeacherDao teacherDao;
    @Test
    public void testFindAll(){
        List<SClass> SClassList = sClassDao.findAll();
        log.info(SClassList.toString());
    }
    @Test
    public void testFindByMajor(){
        Major major = majorDao.findByName("软件工程");
        List<SClass> sClassList = sClassDao.findByMajor(major);
        log.info(sClassList.toString());
    }

    @Test
    public void testFindByName(){
        List<SClass> sClassList = sClassDao.findByName("软件工程2101");
        log.info(sClassList.toString());
    }
    @Test
    public void testFindByName1(){
        Specification<SClass>specification=new Specification<SClass>() {
            @Override
            public Predicate toPredicate(Root<SClass> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                Predicate like=criteriaBuilder.like(name.as(String.class),"软件%");
                return like;
            }
        };
        Sort sort=Sort.by(Sort.Direction.ASC,"classId");
        List<SClass> sClassList = sClassDao.findAll(specification, sort);
        sClassList.forEach(item->{
            System.out.println(item);
        });
    }
    @Test
    public void findIdList(){
        List<Integer> list1 = sClassDao.findByDepartmentId(3);
        log.info(String.valueOf(list1));
        List<Integer> list2 = teacherDao.findAllClass();
        log.info(String.valueOf(list2));
        List<Integer>list=list1.stream().filter(integer -> !list2.contains(integer)).collect(Collectors.toList());
        List<SClass> classList = sClassDao.findList(list);
//        sClassDao.findById(list)
        log.info(String.valueOf(classList));
    }
    @Test
    public void findList(){
        List list= new ArrayList();
        list.add(2);
        list.add(3);
        List<SClass> sClass = sClassDao.findList(list);
        log.info(sClass.toString());
    }
    @Test
    public void classNum(){
        Integer classNum = sClassDao.findClassNum(3);
        log.info(String.valueOf(classNum));
    }
}