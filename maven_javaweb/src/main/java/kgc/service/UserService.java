package cn.kgc.service;

import cn.kgc.entity.User;

import java.util.List;

/**
 * @author: Administrator
 * @Date: 2019/10/16 17:00
 */
public interface UserService {
    public List<User> getUser(String username);

    public User getUserByNameAndPwd(String userName, String pwd);

    //获取所有的数据
    public List<User> getUsers();

    public User getUserById(String userId);
}
