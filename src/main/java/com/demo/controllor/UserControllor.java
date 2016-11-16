package com.demo.controllor;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zj
 * @date 2016-11-16 17:28
 * @description
 */
@RestController
@RequestMapping("user")
public class UserControllor {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public Map<String,Object> getContact(){
        Map data = new HashMap<>();
        List<User> list = userService.getAllUser();
        data.put("data", list);
        return data;
    }
}
