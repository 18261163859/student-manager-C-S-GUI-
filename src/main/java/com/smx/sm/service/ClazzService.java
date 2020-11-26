package com.smx.sm.service;

import com.smx.sm.entity.Clazz;

import java.util.List;

/**
 * @ClassName ClazzService
 * @Description TODO
 * @Author moses
 * @Date 2020/11/26
 **/
public interface ClazzService {
    /**
     * 根据院系号查询该院系下的班级
     * @param departmentId 院系号
     */
    List<Clazz> getClazzByDepId(int departmentId);
    /**
     *新增班级
     * @param clazz 班级实体
     * @return int
     *
     */
    int addClazz(Clazz clazz);

    /**
     * 删除id
     * @param id
     * @return
     */
    int deleteClazz(Integer id);
}
