package com.smx.sm.factory;

import com.smx.sm.service.AdminService;
import com.smx.sm.service.ClazzService;
import com.smx.sm.service.DepartmentService;
import com.smx.sm.service.impl.AdminServiceImpl;
import com.smx.sm.service.impl.ClazzServiceImpl;
import com.smx.sm.service.impl.DepartmentServiceImpl;

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

    public static DepartmentService getDepartmentServiceInstance(){
        return new DepartmentServiceImpl();
    }

    public static ClazzService getClazzServiceInstance(){
        return new ClazzServiceImpl();
    }

}
