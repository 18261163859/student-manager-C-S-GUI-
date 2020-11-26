package com.smx.sm.dao.impl;

import com.smx.sm.dao.ClazzDao;
import com.smx.sm.entity.Clazz;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClazzDaoImplTest {

    ClazzDao dao=new ClazzDaoImpl();
    @Test
    void selectByDepartmentId() {
        try {
            List<Clazz> clazzList=dao.selectByDepartmentId(1);
            System.out.println(clazzList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    void insertClazz() {
    }

    @Test
    void deleteClazz() {
    }
}