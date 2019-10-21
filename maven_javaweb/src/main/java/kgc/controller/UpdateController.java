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

/**
 * @author: Administrator
 * @Date: 2019/10/18 15:42
 */
@WebServlet(name = "UpdateController",urlPatterns = "/update")
public class UpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        UserService userService = new UserServiceImpl();
        User user = userService.getUserById(id);
        if(user!=null){
            req.setAttribute("user",user);
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/500.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("aaaaaaaaaaa");
    }
}
