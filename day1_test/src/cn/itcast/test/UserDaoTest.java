package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domin.User;
import org.junit.Test;

/**
 * @author Ling
 * Created on 2020/1/12
 */
public class UserDaoTest {

    @Test
    public void testLogin(){
        User user = new User();
        user.setUsername("superbaby");
        user.setPassword("123");
        UserDao userDao = new UserDao();
        User userLogin = userDao.login(user);
        System.out.println(userLogin);
    }
}
