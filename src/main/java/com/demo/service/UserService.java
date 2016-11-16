package com.demo.service;

import com.demo.Form.SearchForm;
import com.demo.entity.User;

import java.util.List;

/**
 * @author zj
 * @date 2016-11-16 17:25
 * @description
 */
public interface UserService {
    /**
     * 列表
     * @return
     */
    List<User> getAllUser();

    /**
     * 搜索
     * @param form
     * @return
     */
    List<User> searchUser(SearchForm form);

    /**
     * 添加
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除
     * @param code
     * @return
     */
    int delUser(String code);

    /**
     * 修改
     * @param user
     * @return
     */
    int editUser(User user);

    /**
     * 禁用
     * @param code
     */
    void forbidden(String code);

    /**
     * 启用
     * @param code
     */
    void enabled(String code);
}
