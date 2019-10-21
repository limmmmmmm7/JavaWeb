package cn.kgc.controller;

import cn.kgc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Administrator
 * @Date: 2019/10/15 13:43
 */
@WebServlet(name = "RegisterController",urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---get请求---");
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---post请求---");
        //设置请求的编码
        req.setCharacterEncoding("utf-8");
        //设置响应的编码
        resp.setCharacterEncoding("utf-8");
        //获取请求中发送过来的数据
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        //封装实体类对象
        User user = new User();
        user.setUserName(username);
        user.setPwd(pwd);

        //把这个实体类信息放到数据库，持久保存
        boolean flag = true;  //实现数据库的方法
        //业务逻辑的判断（进行页面的跳转）
        if(flag){
            resp.sendRedirect("/login.jsp");
        }else{
            resp.sendRedirect("/register.jsp");
        }



        System.out.println("username="+ username);
    }
}
