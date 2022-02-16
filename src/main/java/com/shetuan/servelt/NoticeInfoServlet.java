package com.shetuan.servelt;

import com.shetuan.bean.Notice;
import com.shetuan.dao.NoticeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoticeInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nid = request.getParameter("nid");

        NoticeDao noticeDao = new NoticeDao();
        Notice notice = new Notice();
        notice = noticeDao.getNoticeById(Integer.parseInt(nid));
        request.setAttribute("notice", notice);
        // 返回到成员信息页面
        request.getRequestDispatcher("admin/notice_update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
