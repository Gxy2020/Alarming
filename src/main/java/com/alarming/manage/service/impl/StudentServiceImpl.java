package com.alarming.manage.service.impl;

import com.alarming.manage.dao.DepartmentDao;
import com.alarming.manage.dao.MajorDao;
import com.alarming.manage.dao.SClassDao;
import com.alarming.manage.dao.StudentDao;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.objectdata.Major;
import com.alarming.manage.objectdata.SClass;
import com.alarming.manage.objectdata.Student;
import com.alarming.manage.service.StudentService;
import com.alarming.manage.utils.DateUtil;
import com.alarming.manage.utils.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname StudentServiceIml
 * @Description TODO
 * @Date 2021/4/7 21:34
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private SClassDao sClassDao;

    @Override
    public Student findByUserAndPassword(String user, String password) {
        Student student = studentDao.findByUserAndPassword(user, password);
        if (student!=null){
            log.info("【用户登录】登录成功，student={}",student);
            return student;
        }else {
            log.info("【用户登录】登录失败，user={},password={}",user,password);
            return null;
        }
    }

    @Override
    public Student findByUser(String user) {
        if (user.length()>0&&!user.equals("")){
        Student student = studentDao.findByUser(user);
            return student;
        }else {
            return null;
        }
    }

    @Override
    public boolean saveStudent(Student student,Integer departmentId,Integer classId,Integer majorId) {
        Student s = studentDao.findByUser(student.getUser());
        if (s!=null){
        return false;
        }else {
            Department department = departmentDao.getOne(departmentId);
            Major major = majorDao.getOne(majorId);
            SClass one = sClassDao.getOne(classId);
            student.setsClass(one);
            student.setDepartments(department);
            student.setMajors(major);
            student.setCreateTime(DateUtil.ToString());
            studentDao.save(student);
            return true;
        }
    }

    @Override
    public boolean delStudent(int id) {
        Student student = studentDao.getOne(id);
        if (student==null){
        return false;
        }else {
            studentDao.deleteById(id);
            return true;
        }
    }

    @Override
    public Page<Student> findStudentPage(Integer pageNum,Integer size ,String str) {
        Pageable pageable=PageRequest.of(pageNum,size, Sort.by(Sort.Direction.ASC,str));
        Page<Student> studentPage=studentDao.findAll(pageable);
        return studentPage;
    }

    @Override
    public List<String> findByDepartment(String departmentName) {
        return null;
    }

    @Override
    public List<Student> findByClassName(String className) {
        return null;
    }

    @Override
    public List<Student> findByClassId(Integer classId) {
        List<Student> studentList = studentDao.findBysClass(classId);
        return studentList;
    }

    @Override
    public List<Student> findByDepartmentIdOrClassId(Integer departmentId, Integer classId) {
        if (departmentId!=null&classId!=null){
            Specification<Student>specification=new Specification<Student>() {
                @Override
                public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    Department one = departmentDao.getOne(departmentId);
                    SClass two = sClassDao.getOne(classId);
                    Path<Object> path = root.get("departments");
                    Path<Object> sClass = root.get("sClass");
                    Predicate p1 = criteriaBuilder.equal(path, one);
                    Predicate p2 = criteriaBuilder.equal(sClass, two);
                    Predicate or = criteriaBuilder.or(p1, p2);
                    return or;
                }
            };
            List<Student> studentList = studentDao.findAll(specification);
            return studentList;
        }if (departmentId==null&classId!=null){
            List<Student> studentList = studentDao.findBysClass(classId);
            return studentList;
        }if (departmentId!=null&classId==null){
            List<Student> studentList = studentDao.findByDepartmentId(departmentId);
            return studentList;
        }else {
            List<Student> studentList = studentDao.findAll();
            return studentList;
        }
    }

    @Override
    public Integer findStudentCount() {
        Integer studentCount = studentDao.countAllBy();
        return studentCount;
    }

    @Override
    public Map findDepartmentStudentPage(Integer pageNum, Integer pageSize, Integer departmentId) {
        Map map=new HashMap();
        List<Student> studentList = studentDao.findByDepartmentId(departmentId);
        PageModel<Student> studentPage=new PageModel<>(studentList,pageSize);
        List<Student> studentPageObjects = studentPage.getObjects(pageNum);
        map.put("content",studentPageObjects);
        map.put("total",studentList.size());
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        return map;
    }

    @Override
    public Map findClassStudentPage(Integer pageNum, Integer pageSize, Integer classId) {
        Map map=new HashMap();
        List<Student> studentList = studentDao.findBysClass(classId);
        PageModel<Student> studentPage=new PageModel<>(studentList,pageSize);
        List<Student> studentPageObjects = studentPage.getObjects(pageNum);
        map.put("content",studentPageObjects);
        map.put("total",studentList.size());
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        return map;
    }

    @Override
    public void updateStudent(String password, String username, String sex, String phone, String email, Integer id) {
        studentDao.updateStudent(password, username, sex, phone, email, id);
    }

}
