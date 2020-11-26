package com.smx.sm.dao.impl;

import com.smx.sm.dao.ClazzDao;
import com.smx.sm.entity.Clazz;
import com.smx.sm.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ClazzDaoImpl
 * @Description TODO
 * @Author moses
 * @Date 2020/11/26
 **/
public class ClazzDaoImpl implements ClazzDao {
    @Override
    public List<Clazz> selectByDepartmentId(int departmentId) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="SELECT * FROM t_class WHERE department_id= ? ORDER BY id DESC ";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setInt(1,departmentId);
        ResultSet rs=pstmt.executeQuery();
        List<Clazz> clazzList = new ArrayList<>();
        while (rs.next()){
            Clazz clazz=new Clazz();
            clazz.setId(rs.getInt("ID"));
            clazz.setDepartmentId(rs.getInt("department_id"));
            clazz.setClassName(rs.getString("class_name"));
            clazzList.add(clazz);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return clazzList;
    }

    @Override
    public int insertClazz(Clazz clazz) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="INSERT INTO t_class (department_id,class_name) VALUES (?,?)";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setInt(1,clazz.getDepartmentId());
        pstmt.setString(2,clazz.getClassName());
        int n=pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int  deleteClazz(Integer id) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="DELETE FROM t_class WHERE t_class.id=?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setInt(1,id);
        int n=pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;

    }
}

