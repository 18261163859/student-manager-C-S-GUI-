package com.smx.sm.service.impl;

import com.smx.sm.dao.ClazzDao;
import com.smx.sm.entity.Clazz;
import com.smx.sm.factory.DaoFactory;
import com.smx.sm.service.ClazzService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ClazzServiceImpl
 * @Description TODO
 * @Author moses
 * @Date 2020/11/26
 **/
public class ClazzServiceImpl implements ClazzService {
    private final ClazzDao clazzDao= DaoFactory.getClazzDaoInstance();
    @Override
    public List<Clazz> getClazzByDepId(int departmentId) {
        List<Clazz> clazzList=null;
        try{
            clazzList=clazzDao.selectByDepartmentId(departmentId);
        }catch (SQLException e){
            System.err.println("根据学号查询班级信息出错");
        }
        return clazzList;


    }

    @Override
    public int addClazz(Clazz clazz) {
        int n=0;
        try{
            n= DaoFactory.getClazzDaoInstance().insertClazz(clazz);
        }catch (SQLException throwables){
            System.err.println("新增班级出现异常");
        }
        return n;
    }

    @Override
    public int deleteClazz(Integer id) {
        int n=0;
        try{
            n=clazzDao.deleteClazz(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
