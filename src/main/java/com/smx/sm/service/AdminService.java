package com.smx.sm.service;

import com.smx.sm.utils.ResultEntity;

/**
 * @ClassName AdminService
 * @Description Admin业务逻辑接口
 * @Author moses
 * @Date 2020/11/26
 **/
public interface AdminService {
    /**
     * 管理员登录
     * @param account 账号
     * @param password 密码
     * @return 返回结果
     */
    ResultEntity adminLogin(String account,String password);
}
