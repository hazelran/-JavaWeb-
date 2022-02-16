package com.shetuan.servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shetuan.bean.*;
import com.shetuan.dao.*;
import com.shetuan.util.Page;

/**
 * 查询的servlet
 * 
 * @author Administrator
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取界面传来的参数
		String search = request.getParameter("search");
		// 判断是要查询那个
		if (search.equals("member")) {//查询member的所有信息 返回集合
			String membername = request.getParameter("name");
			String cpagestr = request.getParameter("cpage");
			int cpage = 1;
			if (cpagestr != null) {
				cpage = Integer.parseInt(cpagestr.trim());
			}

			Page page = new Page();
			page.setPageCurrent(cpage);

			MemberDao memberdao = new MemberDao();
			List<Member> members = memberdao.getMemberForSerach(membername, page);

			request.setAttribute("members", members);
			request.setAttribute("page", page);
			//返回到成员列表的界面
			request.getRequestDispatcher("member_list.jsp").forward(request, response);
		}else if (search.equals("com")) {
			//查询community的所有信息 返回集合
			String comname = request.getParameter("name");
			String cpagestr = request.getParameter("cpage");
			int cpage = 1;
			if (cpagestr != null) {
				cpage = Integer.parseInt(cpagestr.trim());
			}

			Page page = new Page();
			page.setPageCurrent(cpage);

			CommunityDao communitydao = new CommunityDao();
			List<Community> communities = communitydao.getCommunitiesForSearch(comname, page);
			request.setAttribute("Community", communities);
			request.setAttribute("page", page);
			//返回到社团列表的界面
			request.getRequestDispatcher("community_list.jsp").forward(request, response);
		}else if (search.equals("act")) {
			//查询activity的所有信息 返回集合
			String actname = request.getParameter("name");
			String apagestr = request.getParameter("apage");
			int apage = 1;
			if (apagestr != null) {
				apage = Integer.parseInt(apagestr.trim());
			}

			Page page = new Page();
			page.setPageCurrent(apage);

			ActivityDao activitydao = new ActivityDao();
			List<Activity> activities = activitydao.getActivitiesForSearch(actname, page);
			request.setAttribute("activity", activities);
			request.setAttribute("page", page);
			//返回到社团活动列表的界面
			request.getRequestDispatcher("communityactivity_list.jsp").forward(request, response);
		} else if (search.equals("notice")) {//查询activity的所有信息 返回集合
			String nname = request.getParameter("name");
			String cpagestr = request.getParameter("cpage");
//			System.out.println("asdfsfsdfsfsdfsdfsdf                        "+nname);
			int cpage = 1;
			if (cpagestr != null) {
				cpage = Integer.parseInt(cpagestr.trim());
			}

			Page page = new Page();
			page.setPageCurrent(cpage);

			NoticeDao noticeDao = new NoticeDao();
			List<Notice> notices = noticeDao.getNoticeForSearch(nname,page);
			request.setAttribute("notices", notices);
			request.setAttribute("page", page);
			//返回到社团列表的界面
			request.getRequestDispatcher("notice_list.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
