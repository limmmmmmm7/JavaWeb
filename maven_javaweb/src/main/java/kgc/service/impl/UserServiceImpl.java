package cn.kgc.service.impl;

import cn.kgc.dao.UserDao;
import cn.kgc.dao.impl.UserDaoImpl;
import cn.kgc.entity.User;
import cn.kgc.service.UserService;

import java.util.List;

/**
 * @author: Administrator
 * @Date: 2019/10/16 17:00
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    /**
     * 查询数据
     */
    public List<User> getUser(String username){
        userDao.getUser(username);
        return null;
    }

    /**
     * 用过用户名和密码查询用户信息
     * @param userName
     * @param pwd
     * @return
     */
    @Override
    public User getUserByNameAndPwd(String userName, String pwd) {
        //创建dao层对象
        UserDao userDao = new UserDaoImpl();
        //通过dao层对象的方;法查询用户信息
        List<User> users = userDao.getUserByName(userName,pwd);
        //判断用户是否唯一
        if(users != null && users.size() == 1){
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userDao.getUsers();
        if (users !=null)
            return users;
        return null;
    }

    @Override
    public User getUserById(String userId) {
       User user = userDao.getUserById(userId);
        return user;
    }
}
