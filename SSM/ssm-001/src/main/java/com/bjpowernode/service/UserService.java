package com.bjpowernode.service;

import com.bjpowernode.pojo.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository(value = "userMapper")
public interface UserService {
    /*
    * /user/selectUserPage?userName=z&userSex=男&page=null
    * */
    List<User> selectUserPage(String userName,String userSex,Integer startRow);

    /*
    * /user/createUser(参数见下面)
    * */
    Integer creatUser(User user);

    /*
    * url	/user/ deleteUserById?userId= 15968162087363060
    * */
    Integer deleteUserById(String userId);

    /*
    * url	/user/getRowCount?userName=z&userSex=男
    * */
    Integer getRowCount(String userName,String userSex);
}
