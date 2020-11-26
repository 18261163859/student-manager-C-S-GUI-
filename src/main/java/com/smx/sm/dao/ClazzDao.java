package com.smx.sm.dao;

import com.smx.sm.entity.Clazz;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ClazzDao
 * @Description TODO
 * @Author moses
 * @Date 2020/11/26
 **/
public interface ClazzDao {
    /**
     * 按照院系id查询班级
     * @param departmentId 院系id
     * @return List<CClass> 院系班级集合
     * @throws SQLException 异常
     */
    List<Clazz> selectByDepartmentId(int departmentId) throws SQLException;
    /**
     * @param clazz 入参实体
     * @return int
     * @throws SQLException  异常
     */
    /**
     * 增加班级
     * @param clazz
     * @return
     * @throws SQLException
     */
    int  insertClazz(Clazz clazz) throws SQLException;

    /**
     * 删除班级
     * @param id
     * @throws SQLException
     */
    int  deleteClazz(Integer id) throws SQLException;
}
