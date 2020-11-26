package com.smx.sm.dao;

import com.smx.sm.entity.Department;
import com.smx.sm.factory.DaoFactory;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDaoTest {

    private final DepartmentDao departmentDao= DaoFactory.getDepartmentDaoInstance();

    @Test
    void getAll() {
        List<Department> departmentList=null;
        try {
            departmentList=departmentDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert departmentList!=null;
        departmentList.forEach(System.out::println);
    }

    @Test
    void insert(){
        int n=0;
        Department department=Department.builder()
                .departmentName("测试院系")
                .logo("B46CA1BE-4AB5-483E-B9C0-F9DE07DD9F04.jpeg")
                .build();

        try {
            n=departmentDao.insertDepartment(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(1,n);
    }


}