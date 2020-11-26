package com.smx.sm.service;

import com.smx.sm.entity.Department;
import com.smx.sm.factory.ServiceFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    private final DepartmentService departmentService= ServiceFactory.getDepartmentServiceInstance();
    @Test
    void selectAll() {
        List<Department> departmentList=departmentService.selectAll();
        departmentList.forEach(System.out::println);
    }
}