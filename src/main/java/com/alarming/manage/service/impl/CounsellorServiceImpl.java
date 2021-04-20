package com.alarming.manage.service.impl;

import com.alarming.manage.dao.CounsellorDao;
import com.alarming.manage.dao.DepartmentDao;
import com.alarming.manage.objectdata.Counsellor;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.service.CounsellorService;
import com.alarming.manage.utils.ConvertUtil;
import com.alarming.manage.utils.DateUtil;
import com.alarming.manage.vo.CounsellorVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname CounsellorServiceImpl
 * @Description TODO
 * @Date 2021/4/8 22:33
 */
@Slf4j
@Service
public class CounsellorServiceImpl implements CounsellorService{
    @Autowired
    private CounsellorDao counsellorDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public Counsellor findByUserAndPassword(String user, String password) {
        Counsellor counsellor = counsellorDao.findByUserAndPassword(user, password);
        if (counsellor!=null){
            log.info("【用户登录】登录成功:counsellor={}",counsellor);
            return counsellor;
        }else {
            log.info("【用户登录】账户或密码错误，user={},password={}",user,password);
            return null;
        }
    }

    @Override
    public List<CounsellorVO> findAll() {
        List<Counsellor> counsellorList = counsellorDao.findAll();
        List counsellorVOList=new ArrayList();
        counsellorList.stream().forEach(item->{
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
        return counsellorVOList;
    }

    @Override
    public boolean saveUser(Counsellor counsellor,Integer departmentId) {
        if (counsellor!=null&&departmentId!=null){
            Department department = departmentDao.getOne(departmentId);
            counsellor.setDepartment(department);
            counsellor.setCreateTime(DateUtil.ToString());
            counsellorDao.save(counsellor);
            log.info("保存用户");
            return true;
        }else {
        return false;
        }
    }

    @Override
    public boolean findByUser(String user) {
        Counsellor counsellor = counsellorDao.findByUser(user);
        if (counsellor==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delUser(Integer id) {
        Counsellor counsellor = counsellorDao.getOne(id);
        if (counsellor==null){
            log.info("删除失败");
            return false;
        }else {
            counsellorDao.deleteById(id);
            log.info("删除成功");
            return true;
        }
    }

    @Override
    public Counsellor getOne(Integer id) {
        return counsellorDao.getOne(id);
    }

    @Override
    public List<Counsellor> findCounsellors() {
        List<Counsellor> counsellorList = counsellorDao.findAll();
        return counsellorList;
    }

    /**
     * 多条件查询
     * @param username
     * @param phone
     * @return
     */
    @Override
    public List<Counsellor> findByUsernameOrPhone(String username, String phone) {
        Specification <Counsellor> specification=new Specification<Counsellor>() {
            @Override
            public Predicate toPredicate(Root<Counsellor> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> usernames = root.get("username");
                Path<Object> phones = root.get("phone");
                Predicate p1=criteriaBuilder.equal(usernames,username);
                Predicate p2=criteriaBuilder.equal(phones,phone);
                Predicate predicate = criteriaBuilder.or(p1, p2);
                return predicate;
            }
        };
        List<Counsellor> counsellorList = counsellorDao.findAll(specification);
        return counsellorList;
    }

    @Override
    public List<Counsellor> findByDepartmentOrUsernameOrPhone(Department department, String username, String phone) {
        Specification <Counsellor> specification=new Specification<Counsellor>() {
            @Override
            public Predicate toPredicate(Root<Counsellor> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> departments = root.get("department");
                Path<Object> usernames = root.get("username");
                Path<Object> phones = root.get("phone");
                Predicate p1=criteriaBuilder.equal(departments,department);
                Predicate p2=criteriaBuilder.equal(usernames,username);
                Predicate p3=criteriaBuilder.equal(phones,phone);
                Predicate predicate = criteriaBuilder.or(p1, p2, p3);
                return predicate;
            }
        };
        List<Counsellor> counsellorList = counsellorDao.findAll(specification);
        return counsellorList;
    }

    @Override
    public Map getByUser(String user) {
        Counsellor counsellor = counsellorDao.findByUser(user);
        Map<String, Object> map = ConvertUtil.object2Map(counsellor);
        return map;
    }

    @Override
    public void updateCounsellor(String password, String username, String sex, String phone, String email, Integer id) {
        counsellorDao.updateCounsellor(password, username, sex, phone, email, id);
    }

    @Override
    public List<Counsellor> findByDepartmentId(Integer departmentId) {
        Department one = departmentDao.getOne(departmentId);
        List<Counsellor> counsellorList = counsellorDao.findByDepartment(one);
        return counsellorList;
    }
}
