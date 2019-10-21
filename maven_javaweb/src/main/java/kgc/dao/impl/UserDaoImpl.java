package cn.kgc.dao.impl;

import cn.kgc.dao.UserDao;
import cn.kgc.entity.User;
import cn.kgc.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Administrator
 * @Date: 2019/10/16 15:45
 */
public class UserDaoImpl implements UserDao {

    JDBCUtils jdbcUtils = new JDBCUtils();

    /**
     * 查询数据
     * @throws Exception
     */
    @Override
    public void getUser(String username){
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        try {
            //获取连接驱动
            conn = jdbcUtils.getConn();
            //3、创建执行sql语句的对象
            state = conn.createStatement();
            //4、执行sql语句，返回结果集
            String sql = "select * from userdb where uname='"+username+"'";
            //String sq1 = "select * from user where name=? and pwd=?";

            System.out.println(sql);
            rs = state.executeQuery(sql);
            //5、处理结果集
            while(rs.next()){
                //表中字段的索引去获取数据
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);
                //通过表中的字段名获取数据
                String s3 = rs.getString("pwd");
                String s4 = rs.getString("sex");
                System.out.println(s1+"\t"+s2+"\t"+s3+"\t"+s4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.release(conn,state,rs);
        }
    }

    //带条件查询
    public List<User> getUserByName(String name, String pwd){
        Connection conn = null;
        PreparedStatement pstate = null;
        ResultSet rs = null;
        try {
            //获取驱动连接
            conn = jdbcUtils.getConn();
            //
            String sql = "select * from userdb where 1=1";
            if(!"".equals(name)){
                sql = sql + " and uname = ?";
            }
            if(!"".equals(pwd)){
                sql = sql + " and pwd = ?";
            }
            System.out.println(sql);
            pstate = conn.prepareStatement(sql);
            //去填充占位符
            if(!"".equals(name)){
                pstate.setString(1,name);
            }
            if(!"".equals(pwd)){
                pstate.setString(2,pwd);
            }
            rs = pstate.executeQuery();

            List<User> users = new ArrayList<>();
            User user = new User();

            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()){
                user.setUserName(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                users.add(user);
            }
            return users;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            jdbcUtils.release(conn,pstate,rs);
        }
    }

    /**
     * 获取所有的数据
     * @return
     */
    @Override
    public List<User> getUsers() {
        Connection conn = null;
        PreparedStatement pstate = null;
        ResultSet rs = null;
        try {
            //获取驱动连接
            conn = jdbcUtils.getConn();
            //
            String sql = "select * from userdb";
            System.out.println(sql);
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            List<User> users = new ArrayList<>();
            User user = null;
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setHobby(rs.getString("hobby"));
                users.add(user);
            }
            return users;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            jdbcUtils.release(conn,pstate,rs);
        }
    }

    /**
     * 通过用户id获取用户信息
     * @param userId
     * @return
     */
    @Override
    public User getUserById(String userId) {
        Connection conn = null;
        PreparedStatement pstate = null;
        ResultSet rs = null;
        try {
            //获取驱动连接
            conn = jdbcUtils.getConn();
            //
            String sql = "select * from userdb where 1=1";
            System.out.println(sql);
            if(!"".equals(userId) && userId !=null){
                sql = sql +" and id=?";
            }
            pstate = conn.prepareStatement(sql);
            if(!"".equals(userId) && userId !=null){
                pstate.setString(1,userId);
            }
            rs = pstate.executeQuery();
            User user = null;
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setHobby(rs.getString("hobby"));
            }
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            jdbcUtils.release(conn,pstate,rs);
        }
    }

    /**
     * 修改数据
     * @throws Exception
     */
    @Override
    public void updateUser(){
        Connection conn = null;
        Statement state = null;
        try {
            conn = jdbcUtils.getConn();
            //3、创建执行sql语句的对象
            state = conn.createStatement();
            //4、执行sql语句
            String sql = "update userdb set pwd='abc' where uname='淼哥'";
            System.out.println(sql);
            int i = state.executeUpdate(sql);
            System.out.println("i="+i);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //释放资源
            jdbcUtils.release1(conn,state);
        }
    }

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        //userDao.getUser("淼哥");
        userDao.getUserByName("苏哥","234");
    }
}
