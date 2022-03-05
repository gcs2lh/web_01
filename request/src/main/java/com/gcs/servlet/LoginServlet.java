package com.gcs.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //后台打印乱码，设置req.setCharacterEncoding("utf-8");接受参数前处理！！！
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String pwd = req.getParameter("password");
        String[] hobbys = req.getParameterValues("hobby");
        System.out.println(username+":"+pwd);
        if(hobbys != null){
            for (int i = 0; i < hobbys.length; i++) {
                System.out.print(hobbys[i]+" ");
            }
        }

        //通过请求转发,resp.setCharacterEncoding("utf-8");防止前端显示乱码
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
        resp.setCharacterEncoding("utf-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
