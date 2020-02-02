package cn.www.dao;

import cn.www.domain.User;

import java.util.List;
import java.util.Map;

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

    int findTotalCount(Map<String, String[]> map);

    List<User> findUserByPage(int start, int rows, Map<String, String[]> map);
}
