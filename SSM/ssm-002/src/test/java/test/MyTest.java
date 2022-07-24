package test;

import com.bjpowernode.pojo.User;
import com.bjpowernode.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_maaper.xml","classpath:applicationContext_service.xml"})
public class MyTest {
    @Autowired
    UserService userService;

    @Test
    public void testSelectUserPage(){
        List<User> list = userService.selectUserPage("五","男",0);
        list.forEach(user-> System.out.println(user));
    }

    @Test
    public void testGetRowCount(){
        int a = userService.getRowCount(null,"男");
        System.out.println(a);
    }

    @Test
    public void testCreateUser(){
        User u = new User("1231231231231","sfz","1231231","mingzi","男","18","游戏");
        int a = userService.createUser(u);
        System.out.println(a);

    }
}
