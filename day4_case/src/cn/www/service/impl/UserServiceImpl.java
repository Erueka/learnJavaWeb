package cn.www.service.impl;

import cn.www.dao.UserDao;
import cn.www.dao.impl.UserDaoImpl;
import cn.www.domain.PageBean;
import cn.www.domain.User;
import cn.www.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author Ling
 * Created on 2020/1/29
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delSelectedUsers(String[] uids) {
        for (String id : uids)
            userDao.delete(Integer.parseInt(id));
    }

    @Override
    public PageBean<User> findUserByPage(int currentPage, int rows, Map<String, String[]> map) {
        PageBean<User> pageBean = new PageBean<>();
        UserDao userDao = new UserDaoImpl();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        int totalCount = userDao.findTotalCount(map);
        pageBean.setTotalCount(totalCount);
        int start = (currentPage - 1) * rows;
        List<User> list = userDao.findUserByPage(start, rows, map);
        pageBean.setList(list);
        pageBean.setTotalPage(totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1);
        return pageBean;
    }
}
