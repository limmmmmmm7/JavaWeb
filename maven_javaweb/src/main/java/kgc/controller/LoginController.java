package cn.kgc.controller;

import cn.kgc.entity.User;
import cn.kgc.service.UserService;
import cn.kgc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Administrator
 * @Date: 2019/10/15 14:46
 */
@WebServlet(name = "LoginController",urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /**
     * 用户登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();

        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //获取数据
        String userName = req.getParameter("username"); //获取用户名
        String pwd = req.getParameter("pwd");  //获取密码

        System.out.println("userName:"+userName);
        System.out.println("pwd:"+pwd);

        //业务逻辑的处理
        User user = userService.getUserByNameAndPwd(userName,pwd); //去查询数据

        //用list集合存储用户对象
        /*List<User> lists = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUserName("路哥");
        user1.setPwd("123");
        user1.setHobby("唱歌，篮球，读书");
        lists.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setUserName("淼哥");
        user2.setPwd("123");
        user2.setHobby("不交作业，麦霸，做菜");
        lists.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setUserName("凡哥");
        user3.setPwd("234");
        user3.setHobby("吃肯德基，葛优躺，游戏之王");
        lists.add(user3);*/

        if(user != null){
            //转发  a b c         key    value
            List<User> lists = userService.getUsers();
            if(lists != null){
                req.setAttribute("lists",lists); //设置对象属性信息
                req.getRequestDispatcher("/list.jsp").forward(req,resp);
            }
            resp.sendRedirect("/login.jsp");;
        }else{
            resp.sendRedirect("/login.jsp");
        }

    }
}
