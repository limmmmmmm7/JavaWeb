package cn.kgc.utils;

import javax.sound.midi.VoiceStatus;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author: Administrator
 * @Date: 2019/10/16 15:39
 */
public class JDBCUtils {
    static String url="";
    static String userName = "";
    static String password = "";
    static String driver = "";

    //static String id = "";

    static {
        //回去资源文件中的配置信息
        Properties properties = new Properties();
        InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            properties.load(in);
            //2、连接数据库（需要用户名和密码以及数据库服务器连接地址）
            url = properties.getProperty("mysql.url");
            userName = properties.getProperty("mysql.username");
            password = properties.getProperty("mysql.password");
            driver = properties.getProperty("mysql.driver");
            //id = properties.getProperty("mysql.id");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取数据连接驱动
     * @return
     * @throws Exception
     */
    public Connection getConn() throws Exception{
        //1、加载数据库驱动
        Class.forName(driver);
        //2、连接数据库（需要用户名和密码以及数据库服务器连接地址）
        //通过连接数据库产生连接数据库的连接对象
        Connection conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }

    /**
     * 释放资源
     * @param conn
     * @param state
     * @param rs
     */
    public void release(Connection conn, Statement state, ResultSet rs){
        //6、释放资源
       release1(conn,state);
        try {
            if(rs !=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //释放资源
    public void release1(Connection conn,Statement state){
        try {
            if(state !=null){
                state.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
