package com.shetuan.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shetuan.bean.*;
import com.shetuan.dao.*;

/**
 * 所有的注册servlet
 * 
 * @author Administrator
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDao logindao = new LoginDao();
		MemberDao memberDao = new MemberDao();
		CommunityDao communitydao = new CommunityDao();
		Object ope = request.getParameter("ope");
		System.out.println("registServlet" + ope);

		if (ope.equals("manager")) {
			/**
			 * LoginRegist
			 */
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String managerId = request.getParameter("power");
			Login login = new Login();
			login.setLoginName(username);
			login.setLoginPass(userpass);
			login.setManagerId(Integer.parseInt(managerId));
			System.out.println(username+userpass+managerId);
			String judge = logindao.addLogin(login);
			if (judge.equals("success")) {
				System.out.println("登录成功");
				request.getRequestDispatcher("admin/manager_add.jsp?rs=success").forward(request, response);
			} else if (judge.equals("exist")) {
				request.getRequestDispatcher("admin/manager_add.jsp?rs=exist").forward(request, response);
			} else {
				request.getRequestDispatcher("admin/manager_add.jsp?rs=fail").forward(request, response);
			}
		} else if (ope.equals("index")) {
			/**
			 * IndexRegist
			 */
			String username = request.getParameter("username");
			String userrealname = request.getParameter("userrealname");
			String userpass = request.getParameter("userpass");
			String usergender = request.getParameter("usergender");
			String useremail = request.getParameter("email");
			String userphone = request.getParameter("phone");
			String usergrade = request.getParameter("usergrade");
			String userinstitute = request.getParameter("userinstitute");
			String useradd = request.getParameter("useradd");
			Login login = new Login();
			login.setLoginName(username);
			login.setLoginPass(userpass);
			Member member = new Member();
			member.setMemberName(userrealname);
			member.setMemberGender(usergender);
			member.setMemberEmail(useremail);
			member.setMemberPhone(userphone);
			member.setMemberGrade(usergrade);
			member.setMemberInstitute(userinstitute);
			member.setMemberAdd(useradd);
			String judge = memberDao.addIndexLogin(login, member);
			if (judge.equals("success")) {
				System.out.println("注册成功");
				request.getRequestDispatcher("regist.jsp?rs=success").forward(request, response);
			} else if (judge.equals("exist")) {
				request.getRequestDispatcher("regist.jsp?rs=exist").forward(request, response);
			} else {
				request.getRequestDispatcher("regist.jsp?rs=fail").forward(request, response);
			}

		} else if (ope.equals("community")) {
			/**
			 * CommunityRegist
			 */
			String cname = request.getParameter("communityName");
			String crname = request.getParameter("createrName");

			String createrId = memberDao.getLoginNameByName(crname);
			/*System.out.println(crname+"and"+createrId);*/
			if (createrId == null) {
				System.out.println("创建者 " + crname );
				request.getRequestDispatcher("admin/community_add.jsp?rs=mNotIn").forward(request, response);
			} else {
				String crdate = request.getParameter("createDate");
				int csum = Integer.parseInt(request.getParameter("communitySum"));
				String crange = request.getParameter("communityRange");
				int cclass = Integer.parseInt(request.getParameter("communityClass"));
				String cInfo = request.getParameter("communityInfo");
				int isCreate = Integer.parseInt(request.getParameter("isCreate"));

				Community community = new Community();
				community.setCommunityName(cname);
				community.setCommunityCreaterId(createrId);
				community.setCommunityCreaterName(crname);
				community.setCommunityCreateDate(crdate);
				community.setCommunityNum(csum);
				community.setCommunityRange(crange);
				community.setCommunityClassId(cclass);
				community.setCommunityInfo(cInfo);
				community.setCommunityCreate(isCreate);
				/*System.out.println("hahahah");*/
				String judge = communitydao.addAdminCommunity(community);
				if (judge.equals("success")) {
					System.out.println("创建成功");
					request.getRequestDispatcher("admin/community_add.jsp?rs=success").forward(request, response);
				} else if (judge.equals("exist")) {
					request.getRequestDispatcher("admin/community_add.jsp?rs=exist").forward(request, response);
				} else {
					request.getRequestDispatcher("admin/community_add.jsp?rs=fail").forward(request, response);
				}
			}
		} else if (ope.equals("activity")) {
			/**
			 * ActivityRegist
			 */
			CommunityDao communityDao = new CommunityDao();
			String cname = request.getParameter("communityName");
			int cid = communityDao.getCommunityIdByCName(cname);
			if (cid == 0) {
				request.getRequestDispatcher("admin/activity_add.jsp?rs=mNotIn").forward(request, response);
			} else {
				Activity activity = new Activity();
				ActivityDao activityDao = new ActivityDao();
				activity.setActivityName(request.getParameter("activityName"));
				activity.setActivityId(0);
				activity.setCommunityName(cname);
				activity.setCommunityId(cid);
				activity.setActivityDate(request.getParameter("activityDate"));
				activity.setActivityPlace(request.getParameter("activityPlace"));
				activity.setActivityInfo(request.getParameter("content"));
				String judge = activityDao.addAdminActivity(activity);
				if (judge.equals("success")) {
                    System.out.println("创建成功");
					request.getRequestDispatcher("admin/activity_add.jsp?rs=success").forward(request, response);
				} else if (judge.equals("exist")) {
					request.getRequestDispatcher("admin/activity_add.jsp?rs=exist").forward(request, response);
				} else {
					request.getRequestDispatcher("admin/activity_add.jsp?rs=fail").forward(request, response);
				}
			}
		} else if (ope.equals("notice")) {
			/**
			 * NoticeRegist
			 */
			CommunityDao communityDao = new CommunityDao();
			NoticeDao noticeDao = new NoticeDao();
			String cid = request.getParameter("communityId");
			int result = communityDao.getCommunityById(Integer.parseInt(cid));
			if (result == 0) {
				request.getRequestDispatcher("admin/notice_add.jsp?rs=mNotIn").forward(request, response);
			} else {
				Notice notice = new Notice();
				notice.setNoticeId(Integer.parseInt(request.getParameter("noticeId")));
				notice.setNoticeName(request.getParameter("noticeName"));
				notice.setNoticeIntroduction(request.getParameter("noticeIntroduction"));
				notice.setNoticeTime(request.getParameter("noticeTime"));
				notice.setCommunityId(Integer.parseInt(request.getParameter("communityId")));
//				notice.setCommunityName(request.getParameter("community_name"));
				String judge = noticeDao.addAdminNotice(notice);
				System.out.println(notice);
				if (judge.equals("success")) {
                    System.out.println("创建成功");
					request.getRequestDispatcher("admin/notice_add.jsp?rs=success").forward(request, response);
				} else if (judge.equals("exist")) {
					request.getRequestDispatcher("admin/notice_add.jsp?rs=exist").forward(request, response);
				} else {
					request.getRequestDispatcher("admin/notice_add.jsp?rs=fail").forward(request, response);
				}
			}
		}else if (ope.equals("apply")) {
			/**
			 * ApplyRegist
			 */
			ApplyDao applyDao = new ApplyDao();
			String cname = request.getParameter("community_name");
			//System.out.println(id);
			//System.out.println("select"+cname);
			int cid = applyDao.getCommunityIdByCName(cname);
			//System.out.println("back"+cid);

			if (cid == 0) {
				request.getRequestDispatcher("admin/userapply.jsp?rs=mNotIn").forward(request, response);
			} else {
				Apply apply = new Apply();
				apply.setLoginName(request.getParameter("loginName"));
				apply.setMember_name(request.getParameter("member_name"));
				apply.setMember_gender(request.getParameter("member_gender"));
				apply.setMember_grade(request.getParameter("member_grade"));
				apply.setMember_institute(request.getParameter("memberInstitute"));
				apply.setCommunity_name(request.getParameter(cname));
				apply.setCommunityId(cid);

				String judge = applyDao.add(apply);

				if (judge.equals("success")) {
					System.out.println("创建成功");
					request.getRequestDispatcher("admin/userapply.jsp?rs=successful").forward(request, response);
				} else {
					request.getRequestDispatcher("admin/userapply.jsp?rs=faile").forward(request, response);
				}
			}
		}

	}

}
