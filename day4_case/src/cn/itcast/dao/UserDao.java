package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/**
 * @author Ling
 * Created on 2020/1/29
 */
public interface UserDao {
    List<User> findAll();
    User findUserByUsernameAndPassword(String username, String password);
    void add(User user);
    void delete(int parseInt);
    User findUserById(int parseInt);
    void update(User user);
}
