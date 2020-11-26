package com.smx.sm.service;

import com.smx.sm.entity.Department;

import java.util.List;

/**
 * @ClassName DepartmentService
 * @Description TODO
 * @Author moses
 * @Date 2020/11/26
 **/
public interface DepartmentService {
    /**
     * 查询所有院系
     * @return
     */
    List<Department> selectAll();

    /**
     * 新增院系
     * @param department
     * @return
     */
    int addDepartment(Department department);

    /**
     * 查询是否删除
     * @param name
     * @return
     */
    void remove(String name);
}
