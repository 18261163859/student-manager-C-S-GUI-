package com.smx.sm.factory;

import com.smx.sm.dao.AdminDao;
import com.smx.sm.dao.impl.AdminDaoImpl;

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
}
