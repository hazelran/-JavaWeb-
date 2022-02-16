package com.shetuan.servelt;

import com.shetuan.bean.Community;
import com.shetuan.dao.CommunityDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommunityInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cname = request.getParameter("cname");
        //System.out.println("aaa");

        CommunityDao communityDao = new CommunityDao();
        Community community = new Community();
        community = communityDao.getCommunityByName(cname);
        request.setAttribute("community", community);
        System.out.println(community);
        // 返回到成员信息页面
        request.getRequestDispatcher("admin/community_update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
