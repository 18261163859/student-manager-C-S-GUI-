package com.smx.sm.dao;

import com.smx.sm.entity.Admin;
import com.smx.sm.factory.DaoFactory;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AdminDaoTest {

    private final AdminDao adminDao= DaoFactory.getAdminDaoInstance();

    @org.junit.jupiter.api.Test
    void findAdminByAccount() {
        Admin admin;
        try {
            admin=adminDao.findAdminByAccount("smx@qq.com");
            assertEquals("盛明星",admin.getAdminName());
            System.out.println(admin);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}