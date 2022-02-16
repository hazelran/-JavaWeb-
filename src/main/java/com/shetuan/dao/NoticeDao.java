package com.shetuan.dao;

import com.shetuan.bean.Activity;
import com.shetuan.bean.Notice;
import com.shetuan.util.Page;

import java.util.*;
import java.sql.*;

public class NoticeDao extends BaseDao{
    /**
     * ????????б?
     *
     * @param page
     *            ??????
     * @return ???漯??
     */
    public List<Notice> getNoticeForPage(Page page) {
        List<Notice> notices = new ArrayList<Notice>();

        try {
            // ???????
            getCon();
            // ?page??????????????
            String countsql = "SELECT COUNT(1) FROM notice ";
            // ???sql
            exeQuery(countsql);
            ResultSet countResultSet = (ResultSet) ps.executeQuery();
            // ?????????????????丳???itemCont
            if (countResultSet.next()) {
                int count = countResultSet.getInt(1);
                page.setItemCont(count);
            }
            // ????????????????
            String sql = "SELECT noticeId,noticeName,noticeIntroduction,noticeTime,communityId,community.community_name FROM community,notice where community.community_id=notice.communityId limit ?,?";
            // ???sql ????????????????????С
            exeQuery(sql, page.getItemStart(), page.getPageSize());
            // ?????????
            ResultSet rs = (ResultSet) ps.executeQuery();
            // ??????????????????????activity????????list????
            while (rs.next()) {
                Notice notice = new Notice();
                notice.setNoticeId(rs.getInt("noticeId"));
                notice.setNoticeName(rs.getString("noticeName"));
                notice.setNoticeIntroduction(rs.getString("noticeIntroduction"));
                notice.setNoticeTime(rs.getString("noticeTime"));
                notice.setCommunityId(rs.getInt("communityId"));
                notice.setCommunityName(rs.getString("community_name"));
                // ?????activity????????activities??????
                notices.add(notice);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // ???????????????
            closeAll();
        }
        return notices;
    }

    /**
     * ???????????????????
     *
     * @param com
     *            ???????????
     * @param page
     *            ??????
     * @return ???????????
     */
    public List<Notice> getNoticeForSearch(String com, Page page) {
        List<Notice> notices = new ArrayList<Notice>();
        try {
            // ???????
            getCon();
            // ?page??????????????
            String countsql = "SELECT COUNT(1) FROM notice WHERE  noticeName like ?";
            // ???sql???????????????????
            exeQuery(countsql, "%" + com + "%");
            // ?????????
            ResultSet countResultSet = (ResultSet) ps.executeQuery();
            // ??????????,???丳???itemCont
            if (countResultSet.next()) {
                int count = countResultSet.getInt(1);
                page.setItemCont(count);
            }
            // ?????????????
            String sql = "SELECT noticeId,noticeName,noticeIntroduction,noticeTime,communityId,community_name FROM community,notice where community.community_id=notice.communityId and noticeName like ? ORDER BY communityId limit ?,?";
            // ???sql??????????????????Σ??????????????С
            exeQuery(sql, "%" + com + "%", page.getItemStart(), page.getPageSize());
            // ?????????
            ResultSet rs = (ResultSet) ps.executeQuery();
            // ?????????????????????notice????????list????
            while (rs.next()) {
                Notice notice = new Notice();
                notice.setNoticeId(rs.getInt("noticeId"));
                notice.setNoticeName(rs.getString("noticeName"));
                notice.setNoticeIntroduction(rs.getString("noticeIntroduction"));
                notice.setNoticeTime(rs.getString("noticeTime"));
                notice.setCommunityId(rs.getInt("communityId"));
                notice.setCommunityName(rs.getString("community_name"));
                // ?????activity????????activities??????
                notices.add(notice);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // ???????????
            closeAll();
        }
        return notices;
    }

    /**
     * ?????????
     * @param notice
     * @return
     */
    public int updateNotice(Notice notice) {
        int result = 0;
        try {
            //???????
            getCon();

            //???е????SQL
            String sql = "update notice set noticeName=?, noticeIntroduction=?, noticeTime=?, communityId=? where noticeId=?";
            //???SQL???????????????????????
            result = exeUpdate(sql,
                    new Object[] { notice.getNoticeName(),notice.getNoticeIntroduction(),notice.getNoticeTime(),notice.getCommunityId(),notice.getNoticeId()});
            System.out.println("??????");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //???????????
            closeAll();
        }
        return result;
    }

    /**
     * ????id???????
     * @param noticeId
     * @return
     */
    public int deleteActivity(int  noticeId) {
        int result = 0;
        try {
            //???????
            getCon();
            //???е????SQL
            String sql3 = "delete from notice where noticeId=?";
            //???SQL???????????????????????
            result = exeUpdate(sql3, noticeId );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //???????????
            closeAll();
        }
        return result;
    }

    /**
     * ???????????
     *
     * @param notice
     * @return
     */
    public String addAdminNotice(Notice notice) {
        String judge = null;
        try {
            // ??????sql
            getCon();
            String sql = "INSERT INTO notice (noticeId,noticeName,noticeIntroduction,noticeTime,communityId)VALUES(?,?,?,?,?)";
            // ???sql ???????????????????????????
            int temp = exeUpdate(sql, notice.getNoticeId(),notice.getNoticeName(),notice.getNoticeIntroduction(),notice.getNoticeTime(),notice.getCommunityId());
            if (temp > 0) {// ??г??
                judge = "success";
            } else {// ??????
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
     * ???????id?????????????
     *
     * @param noticeId
     * @return
     */
    public Notice getNoticeById(int noticeId) {
        Notice notice = new Notice();
        try {
            // ???????
            getCon();
            // ???е?sql???
            String sql = "SELECT noticeId,noticeName,noticeIntroduction,noticeTime,communityId,community.community_name FROM community,notice where community.community_id=notice.communityId and noticeId=?";
            // ???sql?????????????id
            exeQuery(sql, noticeId);
            // ?????н??
            ResultSet rs = (ResultSet) ps.executeQuery();
            // ?????????????????????activity????
            if (rs.next()) {
                /*
                 * ???????е????????
                 */
                notice.setNoticeId(rs.getInt("noticeId"));
                notice.setNoticeName(rs.getString("noticeName"));
                notice.setNoticeIntroduction(rs.getString("noticeIntroduction"));
                notice.setNoticeTime(rs.getString("noticeTime"));
                notice.setCommunityId(rs.getInt("communityId"));
                notice.setCommunityName(rs.getString("community_name"));
                System.out.println(notice);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // ???????????
            closeAll();
        }
        return notice;
    }

    /**
     * ????????????????id
     *
     * @param name
     * @return
     */
    public int getCommunityIdByCName(String name) {
        int noticeid = 0;
        try {
            // ??????????????????????????????????????
            if (connection == null) {
                getCon();
            }
            // ????sql
            String sql = "select noticeid from notice where noticename=?";
            // ???sql???????????????????
            exeQuery(sql, name);
            // ?????????
            ResultSet rs = (ResultSet) ps.executeQuery();
            // ??????????????? community_id ?
            if (rs.next()) {
                noticeid = rs.getInt("noticeid");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return noticeid;
    }
}
