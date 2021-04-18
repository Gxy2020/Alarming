package com.alarming.manage.service.impl;

import com.alarming.manage.dao.*;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.objectdata.Major;
import com.alarming.manage.objectdata.SClass;
import com.alarming.manage.service.SClassService;
import com.alarming.manage.utils.DateUtil;
import com.alarming.manage.vo.ClassVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author GUO
 * @Classname SClassServiceImpl
 * @Description TODO
 * @Date 2021/4/14 17:57
 */
@Slf4j
@Service
public class SClassServiceImpl implements SClassService {
    @Autowired
    private SClassDao sClassDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private MajorDao majorDao;

    @Override
    public List<SClass> findAll() {
        List<SClass> classList = sClassDao.findAll();
        return classList;
    }

    /**
     * 按照院系查找学生所在的班级
     *
     * @param departmentId
     * @return
     */
    @Override
    public List<SClass> findByDepartment(Integer departmentId) {
        Department department = departmentDao.getOne(departmentId);
        List<SClass> classList = sClassDao.findByDepartment(department);
        return classList;
    }

    /**
     * 添加班主任,查询没有班主任的班级
     *
     * @param departmentId
     * @return
     */
    @Override
    public List<SClass> findByDepartmentId(Integer departmentId) {
        //按院系查询班级id
        List<Integer> list1 = sClassDao.findByDepartmentId(departmentId);
        //查询已有班主任的班级id
        List<Integer> list2 = teacherDao.findAllClass();
        //过滤已有班主任的班级id
        List<Integer> list = list1.stream().filter(integer -> !list2.contains(integer)).collect(Collectors.toList());
        //按List的id查询,返回List<SClass>对象
        List<SClass> classList = sClassDao.findList(list);
        return classList;
    }

    @Override
    public List<ClassVO> findClassVO() {
        List<SClass> sClassList = sClassDao.findAll();
        List<ClassVO> classVOList = ToClassVo(sClassList);
     /*   List list = new ArrayList();
        for (SClass sClass : sClassList) {
            ClassVO classVO = new ClassVO();
            classVO.setClassId(sClass.getClassId());
            classVO.setName(sClass.getName());
            classVO.setDepartmentName(sClass.getDepartment().getName());
            classVO.setMajorName(sClass.getMajor().getName());
            classVO.setCreateName(sClass.getCreateTime());
            Integer count = studentDao.findCountByClassId(sClass.getClassId());
            classVO.setStudentNum(count);
            list.add(classVO);
        }*/
        return classVOList;
    }

    @Override
    public List<ClassVO> findByDepartmentIdOrMajorId(Integer departmentId, Integer majorId) {
        Specification<SClass> specification = new Specification<SClass>() {
            @Override
            public Predicate toPredicate(Root<SClass> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> department = root.get("department");
                Path<Object> major = root.get("major");
                Department d = departmentDao.getOne(departmentId);
                Major m = majorDao.getOne(majorId);
                Predicate p1 = criteriaBuilder.equal(department, d);
                Predicate p2 = criteriaBuilder.equal(major, m);
                Predicate or = criteriaBuilder.or(p1, p2);
                return or;
            }
        };
//        List list = new ArrayList();
        List<SClass> classList = sClassDao.findAll(specification);
        List<ClassVO> classVOList = ToClassVo(classList);
/*            for (SClass sClass : classList) {
                ClassVO classVO = new ClassVO();
                classVO.setClassId(sClass.getClassId());
                classVO.setName(sClass.getName());
                classVO.setDepartmentName(sClass.getDepartment().getName());
                classVO.setMajorName(sClass.getMajor().getName());
                classVO.setCreateName(sClass.getCreateTime());
                Integer count = studentDao.findCountByClassId(sClass.getClassId());
                classVO.setStudentNum(count);
                list.add(classVO);
            }*/
        return classVOList;
    }

    @Override
    public List<Map<String,Object>> findByMajorId(Integer majorId) {
        List<Map<String, Object>> list = sClassDao.findByMajorId(majorId);
        return list;
    }

    @Override
    public boolean saveClass(Integer departmentId, Integer majorId, String name) {
        SClass sClass = sClassDao.findByName(name);
        if (sClass!=null){
        return false;
        }else {
            SClass aClass = new SClass();
            Department department = departmentDao.getOne(departmentId);
            Major major = majorDao.getOne(majorId);
            aClass.setName(name);
            aClass.setDepartment(department);
            aClass.setMajor(major);
            aClass.setCreateTime(DateUtil.ToString());
            return  true;
        }
    }

    // 工具方法
    public List<ClassVO> ToClassVo(List<SClass> classList){
        List list = new ArrayList();
        for (SClass sClass : classList) {
            ClassVO classVO = new ClassVO();
            classVO.setClassId(sClass.getClassId());
            classVO.setName(sClass.getName());
            classVO.setDepartmentName(sClass.getDepartment().getName());
            classVO.setMajorName(sClass.getMajor().getName());
            classVO.setCreateName(sClass.getCreateTime());
            Integer count = studentDao.findCountByClassId(sClass.getClassId());
            classVO.setStudentNum(count);
            list.add(classVO);
        }
        return list;
    }
}
