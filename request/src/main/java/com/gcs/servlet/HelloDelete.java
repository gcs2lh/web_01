package com.gcs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.MysqlUtil;

/**
 * Servlet implementation class HelloDelete
 */
@WebServlet("/HelloDelete")
public class HelloDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");

        String pno = request.getParameter("p_no");


        String sqlDel = "delete from person where p_no="+pno;


        int message = MysqlUtil.del(sqlDel);
        String rep = "";
        if(message == 1) {
            rep = "{\"code\":\"200\",\"message\":\"成功删除\"}";
        }else {
            rep = "{\"code\":\"999\",\"message\":\"删除失败\"}";
        }
        response.getWriter().write(rep);
    }

}
