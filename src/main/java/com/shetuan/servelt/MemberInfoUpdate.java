package com.shetuan.servelt;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shetuan.bean.Member;
import com.shetuan.dao.CommunityDao;
import com.shetuan.dao.MemberDao;

public class MemberInfoUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MemberDao memberdao = new MemberDao();
        try {
            Member member = new Member();
            CommunityDao communityDao = new CommunityDao();
            member.setLoginName(request.getParameter("loginName"));
            member.setMemberName(request.getParameter("memberName"));
            member.setMemberGender(request.getParameter("memberGender"));
            member.setMemberAdd(request.getParameter("memberAdd"));
            member.setMemberGrade(request.getParameter("memberGrade"));
            member.setMemberInstitute(request.getParameter("memberInstitute"));
            member.setMemberEmail(request.getParameter("memberEmail"));
            member.setMemberPhone(request.getParameter("memberPhone"));
			/*	member.setIscreatCommunity(Integer.parseInt(request.getParameter("iscreat")));*/
            member.setIsJoinCommunity(communityDao.getCommunityIdByCName(request.getParameter("jcom")));
            member.setJoinCommunity(request.getParameter("jcom"));
            System.out.println("+++member="+member);
//				member.setMemberHeader(fileName);
//
//            System.out.println("name:" + member.getMemberName());
//            System.out.println("phone:" + member.getMemberPhone());

            int rs = memberdao.updateMember(member);

            if (rs > 0) {
                System.out.println("result="+rs);
                request.getSession().setAttribute("member", member);
                System.out.println(member+"更新成功");
                response.sendRedirect("admin/memberInfo.jsp?rs=success");
            } else {
                request.getRequestDispatcher("admin/memberInfo.jsp?rs=fail").forward(request, response);
            }
//			}
		/*} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
