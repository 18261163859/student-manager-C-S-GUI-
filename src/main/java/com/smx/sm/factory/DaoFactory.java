package com.smx.sm.factory;

import com.smx.sm.dao.AdminDao;
import com.smx.sm.dao.ClazzDao;
import com.smx.sm.dao.DepartmentDao;
import com.smx.sm.dao.impl.AdminDaoImpl;
import com.smx.sm.dao.impl.ClazzDaoImpl;
import com.smx.sm.dao.impl.DepartmentDaoImpl;

/**
 * @ClassName DaoFactory
 * @Description 工厂类
 * @Author moses
 * @Date 2020/11/26
 **/
public class DaoFactory {
    /**
     * 获得AdminDao实例
     * @return
     */
    public static AdminDao getAdminDaoInstance(){
        return new AdminDaoImpl();
    }

    /**
     * 获取DepartmentDao实例
     * @return
     */
    public static DepartmentDao getDepartmentDaoInstance(){ return new DepartmentDaoImpl(); }

    /**
     * 获取ClazzDao实例
     * @return
     */
    public static ClazzDao getClazzDaoInstance(){
        return new ClazzDaoImpl();
    }
}
