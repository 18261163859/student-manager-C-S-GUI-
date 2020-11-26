package com.smx.sm.dao;

import com.smx.sm.entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DepartmentDao
 * @Description 院系DAO接口
 * @Author moses
 * @Date 2020/11/26
 **/
public interface DepartmentDao {
    /**
     * 查询所有院系
     * @return
     * @throws SQLException 异常
     */
    List<Department> getAll() throws SQLException;


    /**
     * 新增院系
     * @param department
     * @return
     * @throws SQLException
     */
    int insertDepartment(Department department) throws SQLException;

    /**
     * 删除
     * @param name
     * @return
     */
    void remove(String name) throws SQLException;
}
