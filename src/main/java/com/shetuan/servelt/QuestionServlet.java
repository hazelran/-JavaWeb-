package com.shetuan.servelt;

import com.shetuan.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class QuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String q1 = request.getParameter("q1");
        System.out.println(q1);
        int sum1 = Integer.parseInt(QuestionDao.question1(q1));
        System.out.println(sum1);

        String q2 = request.getParameter("q2");
        System.out.println(q2);
        int sum2 = Integer.parseInt(QuestionDao.question2(q2));
        System.out.println(sum2);

        String q3 =request.getParameter("q3");
        System.out.println(q3);
        int sum3 = Integer.parseInt(QuestionDao.question3(q3));
        System.out.println(sum3);

        String q4 =request.getParameter("q4");
        System.out.println(q4);
        int sum4 = Integer.parseInt(QuestionDao.question4(q4));
        System.out.println(sum4);

        String q5 =request.getParameter("q5");
        System.out.println(q5);
        int sum5 = Integer.parseInt(QuestionDao.question5(q5));
        System.out.println(sum5);

        String q6 =request.getParameter("q6");
        System.out.println(q6);
        int sum6 = Integer.parseInt(QuestionDao.question6(q6));
        System.out.println(sum6);

        String sum = Integer.toString(sum1 + sum2 + sum3 + sum4 + sum5 + sum6);
        String summ = QuestionDao.output(sum);

        //request.setAttribute("社团推荐","根据您的问卷我们为您推荐社团如下"+summ);
        //request.getRequestDispatcher("child.html").forward(request,response);

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;setchar=utf-8");

        PrintWriter pw = response.getWriter();
        pw.write("<script language='javascript'>alert('根据您的问卷我们为您推荐社团如下"+summ+"');window.location.href='index2.jsp';</script>");
    }

}
