package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/**
 * @author Ling
 * Created on 2020/1/29
 */
public interface UserDao {
    List<User> findAll();
}
