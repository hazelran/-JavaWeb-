package com.shetuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shetuan.bean.Activity;
import com.shetuan.bean.Community;
import com.shetuan.util.Page;

/**
 * 社团信息的增删改查
 * 
 * @author Administrator
 */
public class CommunityDao extends BaseDao {

	/**
	 * 获取社团列表
	 * 
	 * @param page
	 *            分页信息
	 * @return 社团集合
	 */
	public List<Community> getCommunitiesForPage(Page page) {
		List<Community> communitys = new ArrayList<Community>();
		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(1) FROM community as c,member as m,communityclass as cl WHERE c.community_createrId=m.login_name and cl.class_id=c.community_class";
			// 执行sql
			exeQuery(countsql);
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果存在结果，将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				System.out.println("CommunityDaozhognde count:" + count);
				page.setItemCont(count);
			}
			// 查询社团的详细信息
			String sql = "SELECT community_name,m.member_name,c.community_creatDate,c.community_num,c.community_range,cl.class_name,c.community_iscreat FROM community as c,member as m,communityclass as cl WHERE c.community_createrId=m.login_name and cl.class_id=c.community_class ORDER BY c.community_id limit ?,?";
			// 执行sql ，传入分页的起始页，每页大小
			exeQuery(sql, page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果存在结果将其封装为一个新的community对象，添加到list集合
			while (rs.next()) {
				Community community = new Community();
				//community.setCommunityId(rs.getInt(1));
				community.setCommunityName(rs.getString(1));
				community.setCommunityCreaterName(rs.getString(2));
				community.setCommunityCreateDate(rs.getString(3));
				community.setCommunityNum(Integer.parseInt(rs.getString(4)));
				community.setCommunityRange(rs.getString(5));
				community.setCommunityClassName(rs.getString(6));
				community.setCommunityCreate(Integer.parseInt(rs.getString(7)));
				// 将新的community对象添加到communitys集合中
				communitys.add(community);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return communitys;
	}

	/**
	 * 根据社团名获取社团详细信息
	 * 
	 * @param communityName
	 * @return
	 */
	public Community getCommunityByName(String communityName) {
		Community community = null;
		try {
			// 获取连接
			getCon();
			// 要执行的sql语句
			String sql = "select * from community where community_name=?";
			// 执行sql，并传入参数：社团名
			exeQuery(sql, communityName);
			// 获取执行结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果存在，将其封装为新的community对象
			if (rs.next()) {
				/*
				 * 获取结果中的每一个字段
				 */
				int cId = rs.getInt("community_id");
 				String cName = rs.getString("community_name");
 				String createrName = rs.getString("community_createrName");
				String createrId = rs.getString("community_createrId");
				String cDate = rs.getString("community_creatDate");
				int cNum = rs.getInt("community_num");
				String cRange = rs.getString("community_range");
				int cClass = rs.getInt("community_class");
				String cClassName = rs.getString("community_className");
				int isCreate = rs.getInt("community_iscreat");
				String cinfo = rs.getString("community_info");
				/*
				 * 创建新的community对象，将获取的字段set进community
				 */
				community = new Community();

				community.setCommunityId(cId);
				community.setCommunityName(cName);
				community.setCommunityCreaterName(createrName);
				community.setCommunityCreaterId(createrId);
				community.setCommunityCreateDate(cDate);
				community.setCommunityNum(cNum);
				community.setCommunityRange(cRange);
				community.setCommunityClassId(cClass);
				community.setCommunityClassName(cClassName);
				community.setCommunityCreate(isCreate);
				community.setCommunityInfo(cinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return community;
	}

	/**
	 * 管理员添加社团
	 * 
	 * @param community
	 * @return
	 */
	public String addAdminCommunity(Community community) {
		String judge = null;
		try {
			// 获取连接
			getCon();
			// 查询社团名称是否可用
			Community comm = getCommunityByName(community.getCommunityName());
			if (comm == null) {// 社团名可用，执行插入
				// 要插入的sql
                getCon();
				String sql = "INSERT INTO community (community_name,community_createrId,community_createrName,community_creatDate,community_num,community_range,community_class,community_iscreat,community_info)VALUES(?,?,?,?,?,?,?,?,?)";
				// 执行sql 传入相关参数，并获取执行影响行数
				int temp = exeUpdate(sql, community.getCommunityName(), community.getCommunityCreaterId(),community.getCommunityCreaterName(),
						community.getCommunityCreateDate(), community.getCommunityNum(), community.getCommunityRange(),
						community.getCommunityClassId(), community.getCommunityCreate(), community.getCommunityInfo());
				if (temp > 0) {// 执行成功
					judge = "success";
				} else {// 执行失败
					judge = "fail";
				}
			} else {// 用户名已经存在，退出注册
				judge = "exist";
			}
		} catch (SQLException e) {
			judge = "fail";
		}finally {
		    closeAll();
        }
		return judge;
	}

	/**
	 * 根据社团名获取社团id
	 * 
	 * @param cname
	 * @return
	 */
	public int getCommunityIdByCName(String cname) {
		int communityid = 0;
		try {
			// 如果当前连接为空，则创建新的连接，否则使用当前连接
			if (connection == null) {
				getCon();
			}
			// 要执行sql
			String sql = "select community_id from community where community_name=?";
			// 执行sql。传入参数：社团名称
			exeQuery(sql, cname);
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 若果结果存在，获取 community_id 值
			if (rs.next()) {
				communityid = rs.getInt("community_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		    closeAll();
        }
		System.out.println(communityid);
		return communityid;
	}

	/**
	 * 为搜索框，获取所有相关社团
	 * 
	 * @param com
	 *            模糊查询的字段
	 * @param page
	 *            分页信息
	 * @return 相关社团结果集合
	 */
	public List<Community> getCommunitiesForSearch(String com, Page page) {
		List<Community> communitys = new ArrayList<Community>();
		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(1) FROM community as c,member as m,communityclass as cl WHERE c.community_createrId=m.login_name and cl.class_id=c.community_class and community_name like ?";
			// 执行sql，并传入参数：模糊字段
			exeQuery(countsql, "%" + com + "%");
			// 获取查询结果
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果结果存在,将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 要查询的社团详细信息
			String sql = "SELECT community_name,m.member_name,c.community_creatDate,c.community_num,c.community_range,cl.class_name,c.community_iscreat FROM community as c,member as m,communityclass as cl WHERE c.community_createrId=m.login_name and cl.class_id=c.community_class and community_name like ? ORDER BY c.community_id limit ?,?";
			// 执行sql，并传入参数：模糊字段，查询起始页，每页大小
			exeQuery(sql, "%" + com + "%", page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果存在，将其封装为新的community对象，添加到list集合
			while (rs.next()) {
				Community community = new Community();
				community.setCommunityName(rs.getString(1));
				community.setCommunityCreaterName(rs.getString(2));
				community.setCommunityCreateDate(rs.getString(3));
				community.setCommunityNum(Integer.parseInt(rs.getString(4)));
				community.setCommunityRange(rs.getString(5));
				community.setCommunityClassName(rs.getString(6));
				community.setCommunityCreate(Integer.parseInt(rs.getString(7)));
				// 添加到communitys集合中
				communitys.add(community);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return communitys;
	}

	/**
	 * 修改社团信息
	 * @param community
	 * @return
	 */
	public int updateCommunity(Community community) {
		int result = 0;
		try {
			//获取连接
			getCon();
			//要执行的更新SQL
			String sql = "update community set community_id=?,community_name=?,community_createrId=?,community_createrName=?,community_creatDate=?,community_num=?,community_range=?,community_class=?,community_className=?,community_iscreat=?,community_info=? where community_id=?";
			//执行SQL传入参数，并获取手影响行数
			result = exeUpdate(sql,
					new Object[] { community.getCommunityId(),community.getCommunityName(),community.getCommunityCreaterId(),
							community.getCommunityCreaterName(),community.getCommunityCreateDate(),
							community.getCommunityNum(),community.getCommunityRange(),community.getCommunityClassId(),
							community.getCommunityClassName(),community.getCommunityCreate(),community.getCommunityInfo(),community.getCommunityId()});
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
	 * 根据社团id删除社团
	 * @param communityId
	 * @return
	 */
	public int deleteCommunity(int  communityId) {
		int result = 0;
		try {
			//获取连接
			getCon();
			//要执行的删除SQL
			String sql = "delete from community where community_id=?";
			String sql2 = "delete from communityclass where community_id=?";
			String sql3 = "delete from activity_detail where community_id=?";
			//执行SQL传入参数，并获取受影响行数
			result = exeUpdate(sql, communityId );
			result = exeUpdate(sql2, communityId);
			result = exeUpdate(sql3, communityId );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有连接
			closeAll();
		}
		return result;
	}

	public List<Community> getCommunitiesByClassId(int classId, Page page) {
		List<Community> communitys = new ArrayList<Community>();
		try {
			// 获取连接
			getCon();
			// 为page分页，查询总记录数
			String countsql = "SELECT count(1) FROM community as c,member as m,communityclass as cl WHERE c.community_createrId=m.login_name and cl.class_id=c.community_class and cl.class_id = ?";
			// 执行sql，并传入参数：模糊字段
			exeQuery(countsql, classId);
			// 获取查询结果
			ResultSet countResultSet = (ResultSet) ps.executeQuery();
			// 如果结果存在,将其赋值给itemCont
			if (countResultSet.next()) {
				int count = countResultSet.getInt(1);
				page.setItemCont(count);
			}
			// 要查询的社团详细信息
			String sql = "SELECT community_name,m.member_name,c.community_creatDate,c.community_num,c.community_range,cl.class_name,c.community_iscreat FROM community as c,member as m,communityclass as cl WHERE c.community_createrId=m.login_name and cl.class_id=c.community_class and  cl.class_id = ? ORDER BY c.community_id limit ?,?";
			// 执行sql，并传入参数：模糊字段，查询起始页，每页大小
			exeQuery(sql, classId, page.getItemStart(), page.getPageSize());
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 如果结果存在，将其封装为新的community对象，添加到list集合
			while (rs.next()) {
				Community community = new Community();
				community.setCommunityName(rs.getString(1));
				community.setCommunityCreaterName(rs.getString(2));
				community.setCommunityCreateDate(rs.getString(3));
				community.setCommunityNum(Integer.parseInt(rs.getString(4)));
				community.setCommunityRange(rs.getString(5));
				community.setCommunityClassName(rs.getString(6));
				community.setCommunityCreate(Integer.parseInt(rs.getString(7)));
				// 添加到communitys集合中
				communitys.add(community);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭所有连接
			closeAll();
		}
		return communitys;

	}

	public int getCommunityById(int id) {
		try {
			// 如果当前连接为空，则创建新的连接，否则使用当前连接
			if (connection == null) {
				getCon();
			}
			// 要执行sql
			String sql = "select * from community where community_id=?";
			// 执行sql。传入参数：社团名称
			exeQuery(sql, id);
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 若果结果存在，获取 community_id 值
			if (rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return 0;
	}

	/**
	 * 根据社团id获取活动详细信息
	 *
	 * @param id
	 * @return
	 */
	public Community getCommunityByIdd(int id) {
		Community community = null;
		try {
			// 如果当前连接为空，则创建新的连接，否则使用当前连接
			if (connection == null) {
				getCon();
			}
			// 要执行sql
			String sql = "select * from community where community_id=?";
			// 执行sql。传入参数：社团名称
			exeQuery(sql, id);
			// 获取查询结果
			ResultSet rs = (ResultSet) ps.executeQuery();
			// 若果结果存在，获取 community_id 值
			if (rs.next()) {
				/*
				 * 获取结果中的每一个字段
				 */
				String cid = rs.getString("community_id");
				String cName = rs.getString("community_name");
				String createrId = rs.getString("community_createrId");
				String createrName = rs.getString("community_createrName");
				String cDate = rs.getString("community_creatDate");
				int cNum = rs.getInt("community_num");
				String cRange = rs.getString("community_range");
				int cClass = rs.getInt("community_class");
				String className = rs.getString("community_className");
				int isCreate = rs.getInt("community_iscreat");
				String cinfo = rs.getString("community_info");

				/*
				 * 创建新的community对象，将获取的字段set进community
				 */
				community = new Community();
				community.setCommunityId(Integer.parseInt(cid));
				community.setCommunityName(cName);
				community.setCommunityCreaterId(createrId);
				community.setCommunityCreateDate(cDate);
				community.setCommunityNum(cNum);
				community.setCommunityRange(cRange);
				community.setCommunityClassId(cClass);
				community.setCommunityCreate(isCreate);
				community.setCommunityCreaterName(createrName);
				community.setCommunityClassName(className);
				community.setCommunityInfo(cinfo);
//				System.out.println(className);
//				System.out.println("32222222222222222222222/22222222222222"+community);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return community;
	}
}
