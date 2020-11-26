package com.smx.sm.factory;

import com.smx.sm.service.AdminService;
import com.smx.sm.service.impl.AdminServiceImpl;

/**
 * @ClassName ServiceFactory
 * @Description Service工厂类
 * @Author moses
 * @Date 2020/11/26
 **/
public class ServiceFactory {
    public static AdminService getAdminServiceInstance(){
        return new AdminServiceImpl();
    }

}