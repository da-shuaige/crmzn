package com.bjpowernode.controller;

import com.bjpowernode.pojo.User;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    public static final int PAGE_SIZE = 5;
    /**
     *     List<User> selectUserPage(
     *             @Param("userName")
     *             String userName,
     *             @Param("userSex")
     *             String userSex,
     *             @Param("startRow")
     *             int startRow);
     * @return
     */
    @RequestMapping("/selectUserPage")
    public List<User> selectUserPage(String userName,String userSex,Integer page){
        int startRow = 0;
        if (page != null){
            startRow = (page-1)*PAGE_SIZE;
        }
        return userService.selectUserPage(userName,userSex,startRow);
    }

    /**
     * url	/user/getRowCount?userName=z&userSex=男
     */
    @RequestMapping("/getRowCount")
    public int getRowCount(String userName,String userSex){
        return userService.getRowCount(userName,userSex);
    }

    /**
     * url	/user/ deleteUserById?userId= 15968162087363060
     */
    @RequestMapping("/deleteUserById")
    public int deleteUserById(String userId){
        return userService.deleteUserById(userId);
    }

    /**
     * url	/user/createUser(参数见下面)
     */
    @RequestMapping("/createUser")
    public int createUser(User user){
        String userId = System.currentTimeMillis()+"";
        user.setUserId(userId);
        return userService.createUser(user);
    }

}
