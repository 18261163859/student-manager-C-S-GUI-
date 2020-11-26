package com.smx.sm.service.impl;

import com.smx.sm.dao.DepartmentDao;
import com.smx.sm.entity.Department;
import com.smx.sm.factory.DaoFactory;
import com.smx.sm.service.DepartmentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DepartmentServiceImpl
 * @Description TODO
 * @Author moses
 * @Date 2020/11/26
 **/
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao= DaoFactory.getDepartmentDaoInstance();

    @Override
    public List<Department> selectAll() {
        List<Department> departmentList=null;
        try {
            departmentList=departmentDao.getAll();
        } catch (SQLException e) {
            System.err.println("查询院系信息出现异常");
        }
        return departmentList;
    }

    @Override
    public int addDepartment(Department department) {
        int n=0;
        try{
            n=departmentDao.insertDepartment(department);
        }catch (SQLException e){
            System.err.println("新增院系出现异常");
        }
        return n;
    }

    @Override
    public void remove(String name) {
        try{departmentDao.remove(name);
        }catch (SQLException e){
            System.err.println("删除错误");
        }
    }
}
