package com.smx.sm.service;

import com.smx.sm.factory.ServiceFactory;
import com.smx.sm.utils.ResultEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {
    private final AdminService adminService= ServiceFactory.getAdminServiceInstance();

    @Test
    void adminLogin() {
        ResultEntity resultEntity=adminService.adminLogin("1smx@qq.com","1234567");
        //assertEquals(0,resultEntity.getCode());
        System.out.println(resultEntity);
    }
}