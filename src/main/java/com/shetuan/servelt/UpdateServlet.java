package com.shetuan.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shetuan.bean.*;
import com.shetuan.dao.*;
/**
 * 所有的更新servlet
 * @author Administrator
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDao logindao = new LoginDao();
		String ope = request.getParameter("ope");
		System.out.println("Updateservlet " + ope);
		if (ope.equals("mupdate")) {
			/**
			 * MemberPassUpdate 修改用户密码
			 */
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String uppass2 = request.getParameter("newpass2");

			Login db_login = logindao.getLoginByName(username);

			System.out.println("loginservlet->update");
			if (db_login == null) {
				request.getRequestDispatcher("manager_update.jsp?rs=namewrong").forward(request, response);
			} else {
				String db_pass = db_login.getLoginPass();
				if (!db_pass.equals(userpass)) {
					System.out.println("db_pass!=uppass" + db_pass + " " + userpass);
					request.getRequestDispatcher("manager_update.jsp?rs=wrong").forward(request, response);
				} else if(db_pass.equals(userpass)){
					int rs = logindao.updatePassword(username, uppass2);
					if (rs > 0) {
						System.out.println("rs>0 " + rs);
						response.sendRedirect("manager_update.jsp?rs=success");
					} else {
						System.out.println("更新失败" + rs);
						request.getRequestDispatcher("manager_update.jsp?rs=fail").forward(request, response);
					}
				}
			}
		} else if (ope.equals("dele")) {
			/**
			 * 根据登陆名删除用户
			 */
			String  loginName = request.getParameter("loginname");
			//System.out.println("adasdadas"+loginName);
			MemberDao memberdao = new MemberDao();
			memberdao.deleteMember(loginName);

			request.getRequestDispatcher("Query?lru=ulist").forward(request, response);
		}else if(ope.equals("aupdate")){
			/**
			 * 修改活动信息
			 */
//			System.out.println("进入更新了吗");
			ActivityDao activityDao = new ActivityDao();
			Activity activity = new Activity();
			activity.setActivityId(Integer.parseInt(request.getParameter("activityId")));
			activity.setCommunityId(Integer.parseInt(request.getParameter("communityId")));
			activity.setActivityName(request.getParameter("activityName"));
			activity.setCommunityName(request.getParameter("communityName"));
			activity.setActivityDate(request.getParameter("activityDate"));
			activity.setActivityPlace(request.getParameter("activityPlace"));
			activity.setActivityInfo(request.getParameter("activityInfo"));
			if (activity == null) {
				request.getRequestDispatcher("activity_update.jsp?rs=namewrong").forward(request, response);
			} else {
				int rs = activityDao.updateActivity(activity);
				if (rs > 0) {
//					System.out.println("rs>0 " + rs);
					request.getSession().setAttribute("activity",activity);
					response.sendRedirect("activity_update.jsp?rs=success");
				} else {
//					System.out.println("更新失败" + rs);
					request.getRequestDispatcher("activity_update.jsp?rs=fail").forward(request, response);
				}
			}
		}else if (ope.equals("adele")) {
			/**
			 * 根据活动id删除活动信息
			 */
//			System.out.println("aid"+Integer.parseInt(request.getParameter("aid")));
			ActivityDao activityDao = new ActivityDao();
			activityDao.deleteActivity(Integer.parseInt(request.getParameter("aid")));
			request.getRequestDispatcher("Query?lru=alist").forward(request, response);
		}else if(ope.equals("cupdate")){
			/**
			 * 修改社团信息
			 */
			//System.out.println("进入更新了吗");
			CommunityDao communityDao = new CommunityDao();
			Community community = new Community();
			community.setCommunityId(Integer.parseInt(request.getParameter("communityId")));
			community.setCommunityName(request.getParameter("communityName"));
			community.setCommunityCreaterId(request.getParameter("communityCreaterId"));
			community.setCommunityCreaterName(request.getParameter("communityCreaterName"));
			community.setCommunityCreateDate(request.getParameter("communityCreateDate"));
			community.setCommunityNum(Integer.parseInt(request.getParameter("communityNum")));
			community.setCommunityRange(request.getParameter("communityRange"));
			community.setCommunityClassId(Integer.parseInt(request.getParameter("communityClassId")));
			community.setCommunityClassName(request.getParameter("communityClassName"));
			community.setCommunityCreate(Integer.parseInt(request.getParameter("communityCreate")));
			community.setCommunityInfo(request.getParameter("communityInfo"));
			if (community == null) {
				request.getRequestDispatcher("community_update.jsp?rs=namewrong").forward(request, response);
			} else {
				int rs = communityDao.updateCommunity(community);
				if (rs > 0) {
//					System.out.println("rs>0 " + rs);
					request.getSession().setAttribute("community",community);
					response.sendRedirect("community_update.jsp?rs=success");
				} else {
//					System.out.println("更新失败" + rs);
					request.getRequestDispatcher("community_update.jsp?rs=fail").forward(request, response);
				}
			}
		}else if (ope.equals("cdele")) {
			/**
			 * 根据社团id删除社团信息
			 */
//			System.out.println("aid"+Integer.parseInt(request.getParameter("aid")));
			CommunityDao communityDao1 = new CommunityDao();
			communityDao1.deleteCommunity(communityDao1.getCommunityIdByCName(request.getParameter("cname")));
			request.getRequestDispatcher("Query?lru=clist").forward(request, response);
		}else if(ope.equals("noticeupdate")){
			/**
			 * 修改公告信息
			 */
			//System.out.println("进入更新了吗");
			NoticeDao noticeDao = new NoticeDao();
			Notice notice = new Notice();
			notice.setNoticeId(Integer.parseInt(request.getParameter("noticeId")));
			notice.setNoticeName(request.getParameter("noticeName"));
			notice.setNoticeIntroduction(request.getParameter("noticeIntroduction"));
			notice.setNoticeTime(request.getParameter("noticeTime"));
			notice.setCommunityId(Integer.parseInt(request.getParameter("communityId")));
			notice.setCommunityName(request.getParameter("communityName"));
			//System.out.println("aaaaa"+notice);
			if (notice == null) {
				System.out.println("namewrong");
				request.getRequestDispatcher("notice_update.jsp?rs=namewrong").forward(request, response);
			} else {
				int rs = noticeDao.updateNotice(notice);
				if (rs > 0) {
					System.out.println("rs>0 " + rs);
					request.getSession().setAttribute("notice",notice);
					response.sendRedirect("notice_update.jsp?rs=success");
				} else {
					System.out.println("更新失败" + rs);
					request.getRequestDispatcher("notice_update.jsp?rs=fail").forward(request, response);
				}
			}
		}else if (ope.equals("noticedele")) {
			/**
			 * 根据公告id删除公告信息
			 */
//			System.out.println("aid"+Integer.parseInt(request.getParameter("nid")));
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.deleteActivity(Integer.parseInt(request.getParameter("nid")));
			request.getRequestDispatcher("Query?lru=nlist").forward(request, response);
		}else if(ope.equals("applyagree")){
			/**
			 * 通过社团审核
			 */
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			ApplyDao applyDao = new ApplyDao();
			Apply apply = new Apply();
			apply.setCommunityId(Integer.parseInt(request.getParameter("communityId")));
			apply.setLoginName(request.getParameter("loginname"));
			if (apply == null) {
				request.setAttribute("rs","wrong");
				request.getRequestDispatcher("Query?lru=applylist").forward(request, response);
			} else {
				int rs = applyDao.agree(apply);
				if (rs > 0) {
					request.setAttribute("rs","success");
					request.getRequestDispatcher("Query?lru=applylist").forward(request, response);
				} else {
					request.setAttribute("rs","wrong");
					request.getRequestDispatcher("Query?lru=applylist").forward(request, response);
				}
			}
		}else if (ope.equals("applydelete")) {
			/**
			 * 删除社团审核
			 */
//			System.out.println("aid"+Integer.parseInt(request.getParameter("nid")));
			ApplyDao applyDao = new ApplyDao();
			int rs = applyDao.delete(request.getParameter("loginname"),Integer.parseInt(request.getParameter("communityId")));
			if(rs>0){
				request.setAttribute("rs","fail");
			}else{
				request.setAttribute("rs","wrong");
			}
			request.getRequestDispatcher("Query?lru=applylist").forward(request, response);
		}else if(ope.equals("mupdate")){
			/**
			 * 修改成员信息
			 */
			System.out.println("进入更新了吗");
			MemberDao memberdao = new MemberDao();

			Member member = new Member();
			member.setLoginName(request.getParameter("loginName"));
			member.setMemberName(request.getParameter("memberName"));
			member.setMemberGender(request.getParameter("memberGender"));
			member.setMemberAdd(request.getParameter("memberAdd"));
			member.setMemberGrade(request.getParameter("memberGrade"));
			member.setMemberInstitute(request.getParameter("memberInstitute"));
			member.setMemberEmail(request.getParameter("memberEmail"));
			member.setMemberPhone(request.getParameter("memberPhone"));
			System.out.println("+++member="+member);

			CommunityDao communityDao = new CommunityDao();
			member.setIsJoinCommunity(communityDao.getCommunityIdByCName(request.getParameter("jcom")));

			int result = memberdao.updateMember(member);

			if (result > 0) {
				System.out.println("result="+result);
				request.getSession().setAttribute("member", member);
				request.getRequestDispatcher("admin/memberInfo.jsp?rs=success");
			} else {
				request.getRequestDispatcher("admin/memberInfo.jsp?rs=fail").forward(request, response);
			}
			}
		}

	}

