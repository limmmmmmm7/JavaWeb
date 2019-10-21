package cn.kgc.dao;

import cn.kgc.entity.User;

import java.util.List;

/**
 * @author: Administrator
 * @Date: 2019/10/16 16:57
 */
public interface UserDao {
    /**
     * 查询数据
     */
    public void getUser(String username);

    /**
     * 修改数据
     */
    public void updateUser();


    public List<User> getUserByName(String userName, String pwd);

    public  List<User> getUsers();

    public User getUserById(String userId);

}
