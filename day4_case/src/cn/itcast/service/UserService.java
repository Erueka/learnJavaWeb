package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

/**
 * @author Ling
 * Created on 2020/1/29
 */
public interface UserService {
    List<User> findAll();

    User login(User user);

    void addUser(User user);

    void delete(String id);

    User findUserById(String id);

    void update(User user);

    void delSelectedUsers(String[] uids);
}
