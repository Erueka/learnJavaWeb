package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;

/**
 * @author Ling
 * Created on 2020/1/29
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        UserDao userDao = new UserDaoImpl();
        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        return new UserDaoImpl().findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
