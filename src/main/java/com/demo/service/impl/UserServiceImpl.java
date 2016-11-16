package com.demo.service.impl;

import com.demo.Form.SearchForm;
import com.demo.entity.User;
import com.demo.service.UserService;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zj
 * @date 2016-11-16 17:26
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT CODE,NAME,REMARK,STATE, CREATETIME,LASTLOGINTIME,TYPE  FROM CONTACT";
        return (List<User>) jdbcTemplate.query(sql, new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setCode(rs.getString("CODE"));
                user.setName(rs.getString("NAME"));
                user.setRemark(rs.getString("REMARK"));
                user.setState(Integer.parseInt(rs.getString("STATE")));
                user.setCreateTime(convertStringToDate(rs.getString("CREATETIME")));
                user.setLastLoginTime(convertStringToDate(rs.getString("LASTLOGINTIME")));
                user.setType(rs.getString("TYPE"));
                return user;
            }

        });
    }

    @Override
    public List<User> searchUser(SearchForm form) {
        return null;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public int delUser(String code) {
        return 0;
    }

    @Override
    public int editUser(User user) {
        return 0;
    }

    @Override
    public void forbidden(String code) {

    }

    @Override
    public void enabled(String code) {

    }

    public static Date convertStringToDate(String date) {
        try {
            SimpleDateFormat mySDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateTemp = mySDF.parse(date);
            return dateTemp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
