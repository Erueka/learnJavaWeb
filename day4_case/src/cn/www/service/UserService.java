package cn.www.service;

import cn.www.domain.PageBean;
import cn.www.domain.User;

import java.util.List;
import java.util.Map;

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

    PageBean<User> findUserByPage(int parseInt, int parseInt1, Map<String, String[]> map);
}
