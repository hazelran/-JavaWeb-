package com.shetuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shetuan.bean.Activity;
import com.shetuan.util.Page;

/**
 * 社团活动的增删改查
 * 
 * @author Administrator
 */
public class ActivityDao extends BaseDao {
	/**
	 * 获取活动列表
	 * 
	 * @param page
	 *            分页信息
	 * @return 社团活动集合
	 */
	public List<Activity> getActivitiesForPage(Page page) {
		List<Activity> activities = new ArrayList<Activity>();

		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT COUNT(1) FROM activity_detail ";
			// 执行sql
			exeQuery(countsql);
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果查询结果存在，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 分页查询活动的详细信息
			String sql = "SELECT activity_id, activity_name,activity_date,community_name,activity_place,activity_info FROM activity_detail limit ?,?";
			// 执行sql ，传入分页的起始页，每页大小
			exeQuery(sql, page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果存在结果将其封装为一个新的activity对象，添加到list集合
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setActivityId(rs.getInt(1));
				activity.setActivityName(rs.getString(2));
				activity.setActivityDate(rs.getString(3));
				activity.setCommunityName(rs.getString(4));
				activity.setActivityPlace(rs.getString(5));
				activity.setActivityInfo(rs.getString(6));
				// 将新的activity对象添加到activities集合中
				activities.add(activity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接，管道
			closeAll();
		}
		return activities;
	}

	/**
	 * 为搜索框，获取所有相关社团活动
	 *
	 * @param act
	 *            模糊查询的字段
	 * @param page
	 *            分页信息
	 * @return 相关社团活动结果集合
	 */
	public List<Activity> getActivitiesForSearch(String act, Page page) {
		List<Activity> activities = new ArrayList<Activity>();
		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(1) FROM activity_detail WHERE activity_name like ?";
			// 执行sql
			exeQuery(countsql, "%" + act + "%");
			// 获取查询结果
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果结果存在,将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 要查询的社团活动详细信息
			String sql = "SELECT activity_name, activity_date, community_name, activity_place, activity_info FROM activity_detail WHERE activity_name like ? ORDER BY activity_id limit ?,?";
			// 执行sql，并传入参数：查询起始页，每页大小
			exeQuery(sql, "%" + act + "%", page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果存在，将其封装为新的community对象，添加到list集合
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setActivityName(rs.getString(1));
				activity.setActivityDate(rs.getString(2));
				activity.setCommunityName(rs.getString(3));
				activity.setActivityPlace(rs.getString(4));
				activity.setActivityInfo(rs.getString(5));
				// 添加到activities集合中
				activities.add(activity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return activities;
	}

	/**
	 * 修改活动信息
	 * @param activity
	 * @return
	 */
	public int updateActivity(Activity activity) {
		int result = 0;
		try {
			//获取连接
			getCon();

			//要执行的更新SQL
			String sql = "update activity_detail set community_id=?,activity_name=?,community_name=?,activity_date=?,activity_place=?,activity_info=? where activity_id=?";
			//执行SQL传入参数，并获取影响行数
			result = exeUpdate(sql,
					new Object[] { activity.getCommunityId(),activity.getActivityName(),activity.getCommunityName(),
							activity.getActivityDate(),activity.getActivityPlace(),activity.getActivityInfo(),activity.getActivityId()});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return result;
	}

	/**
	 * 根据id删除活动
	 * @param activityId
	 * @return
	 */
	public int deleteActivity(int  activityId) {
		int result = 0;
		try {
			//获取连接
			getCon();
			//要执行的删除SQL
			String sql3 = "delete FROM activity_detail where activity_id=?";
			//执行SQL传入参数，并获取受影响行数
			result = exeUpdate(sql3, activityId );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return result;
	}

	/**
	 * 管理员添加活动
	 *
	 * @param activity
	 * @return
	 */
	public String addAdminActivity(Activity activity) {
		String judge = null;
		try {
			// 要插入的sql
			getCon();
			String sql = "INSERT INTO activity_detail (activity_id,community_id,activity_name,community_name,activity_date,activity_place,activity_info)VALUES(?,?,?,?,?,?,?)";
			// 执行sql 传入相关参数，并获取执行影响行数
			int temp = exeUpdate(sql, activity.getActivityId(),activity.getCommunityId(),activity.getActivityName(),activity.getCommunityName(),
					activity.getActivityDate(),activity.getActivityPlace(),activity.getActivityInfo());
			if (temp > 0) {// 执行成功
				judge = "success";
			} else {// 执行失败
				judge = "fail";
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			closeAll();
		}
		return judge;
	}

	/**
	 * 根据活动id获取活动详细信息
	 *
	 * @param activityId
	 * @return
	 */
	public Activity getActivityById(int activityId) {
		Activity activity = new Activity();
		try {
			// 获取连接
			getCon();
			// 要执行的sql语句
			String sql = "select * from activity_detail where activity_id=?";
			// 执行sql，并传入参数：id
			exeQuery(sql, activityId);
			// 获取执行结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果存在，将其封装为新的activity对象
			if (rs.next()) {
				/*
				 * 获取结果中的每一个字段
				 */
				activity.setActivityId(Integer.parseInt(rs.getString("activity_id")));
				activity.setCommunityId(Integer.parseInt(rs.getString("community_id")));
				activity.setActivityName(rs.getString("activity_name"));
				activity.setCommunityName(rs.getString("community_name"));
				activity.setActivityDate(rs.getString("activity_date"));
				activity.setActivityPlace(rs.getString("activity_place"));
				activity.setActivityInfo(rs.getString("activity_info"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return activity;
	}

	public List<Activity> getActivitiesByCId(int cid, Page page) {
		List<Activity> activities = new ArrayList<Activity>();
		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(1) FROM activity_detail WHERE community_id= ?;";
			// 执行sql，并传入参数：模糊字段
			exeQuery(countsql, cid);
			// 获取查询结果
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果结果存在,将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 要查询的活动详细信息
			String sql = "SELECT * FROM activity_detail where community_id= ? ;";
			// 执行sql，并传入参数：模糊字段，查询起始页，每页大小
			exeQuery(sql, cid);
//			System.out.println("SELECT * FROM activity_detil where community_id="+ cid+" limit"+ page.getItemStart()+","+page.getPageSize()+";");
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
//			System.out.println(rs.first());
			// 如果结果存在，将其封装为新的activity对象，添加到list集合
			while (rs.next()) {
				Activity activity = new Activity();
//				System.out.println("asdasd"+rs.getString("activity_id"));
				activity.setActivityId(Integer.parseInt(rs.getString("activity_id")));
				activity.setCommunityId(Integer.parseInt(rs.getString("community_id")));
				activity.setActivityName(rs.getString("activity_name"));
				activity.setCommunityName(rs.getString("community_name"));
				activity.setActivityDate(rs.getString("activity_date"));
				activity.setActivityPlace(rs.getString("activity_place"));
				activity.setActivityInfo(rs.getString("activity_info"));
				// 添加到activitys集合中
				activities.add(activity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return activities;
	}
}
