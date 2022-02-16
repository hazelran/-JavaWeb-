package com.shetuan.dao;

import com.shetuan.bean.Apply;
import com.shetuan.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplyDao extends BaseDao{

    /**
     * ��ȡ�����б�
     *
     * @param page
     *            ��ҳ��Ϣ
     * @return ���뼯��
     */
    public List<Apply> getApplyForPage(Page page) {
        List<Apply> applys = new ArrayList<Apply>();
        System.out.println("------------------------------------------------");
        try {
            // ��ȡ����
            getCon();
            // Ϊpage��ҳ����ѯ�ܼ�¼��
            String countsql = "SELECT COUNT(1) FROM apply ";
            // ִ��sql
            exeQuery(countsql);
            ResultSet countResultSet = (ResultSet) ps.executeQuery();
            // �����ѯ������ڣ����丳ֵ��itemCont
            if (countResultSet.next()) {
                int count = countResultSet.getInt(1);
                page.setItemCont(count);
            }
            // ��ҳ��ѯ�����ϸ��Ϣ
//            String sql = "SELECT * FROM cost limit ?,?";
            String sql = " select loginname,member_name,member_gender,member_grade,member_institute,community_name,communityId,applyId from apply,community,member WHERE apply.loginname=member.login_name and apply.communityId=community.community_id and communityId>0 limit ?,?";
            // ִ��sql �������ҳ����ʼҳ��ÿҳ��С
            exeQuery(sql, page.getItemStart(), page.getPageSize());
            // ��ȡ��ѯ���
            ResultSet rs = (ResultSet) ps.executeQuery();
            // ������ڽ�������װΪһ���µ�activity������ӵ�list����
            while (rs.next()) {
                Apply apply = new Apply();
                apply.setLoginName(rs.getString(1));
                apply.setMember_name(rs.getString(2));
                apply.setMember_gender(rs.getString(3));
                apply.setMember_grade(rs.getString(4));
                apply.setMember_institute(rs.getString(5));
                apply.setCommunity_name(rs.getString(6));
                apply.setCommunityId(Integer.parseInt(rs.getString(7)));
                // ���µ�activity������ӵ�activities������
                System.out.println(apply);
                applys.add(apply);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // �ر��������ӣ��ܵ�
            closeAll();
        }
        return applys;
    }

    //�ܾ�����
    public int delete(String loginName,int communityId) {
        int result = 0;
        try {
            //��ȡ����
            getCon();
            //Ҫִ�е�ɾ��SQL
            String sql = "delete FROM apply WHERE communityId=? and loginname=?";
            //ִ��SQL�������������ȡ��Ӱ������
            result = exeUpdate(sql, communityId,loginName );
            //System.out.println("ɾ��");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //�ر���������
            closeAll();
        }
        return result;
    }

    //ͬ������
    public int agree(Apply apply) {
        int result = 0;
        try {
            //��ȡ����
            getCon();
            //Ҫִ�еĸ���SQL
            String sql = "update member SET join_communityId=? WHERE login_name=?";
            //ִ��SQL�������������ȡӰ������
            result = exeUpdate(sql,
                    new Object[] { apply.getCommunityId(),apply.getLoginName()});
            result =delete(apply.getLoginName(),apply.getCommunityId());
            //System.out.println("ͬ��");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //�ر���������
            closeAll();
        }
        return result;
    }

    //�������
    public String add(Apply apply) {
        String judge = null;
        try {
            //��ȡ����
            getCon();
            //Ҫִ�еĸ���SQL
            String sql = "insert into apply(loginname,communityId) values(?,?);";
            //ִ��SQL�������������ȡӰ������
            int result = exeUpdate(sql,
                    new Object[] { apply.getLoginName(),apply.getCommunityId()});

//            result =delete(apply.getLoginName(),apply.getCommunityId());
            if(result > 0){
                //ִ�гɹ�
                judge = "success";
            }else{
                //ִ��ʧ��
                judge = "fail";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //�ر���������
            closeAll();
        }
        return judge;
    }

    /**
     * ���ݹ�������ȡ����id
     *
     * @param name
     * @return
     */
    public int getCommunityIdByCame(String name) {
        int noticeid = 0;
        try {
            // �����ǰ����Ϊ�գ��򴴽��µ����ӣ�����ʹ�õ�ǰ����
            if (connection == null) {
                getCon();
            }
            // Ҫִ��sql
            String sql = "select noticeid from notice where noticename=?";
            // ִ��sql�������������������
            exeQuery(sql, name);
            // ��ȡ��ѯ���
            ResultSet rs = (ResultSet) ps.executeQuery();
            // ����������ڣ���ȡ community_id ֵ
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

    /**
     * ������������ȡ����id
     *
     * @param cname
     * @return
     */
    public int getCommunityIdByCName(String cname) {
        int communityid = 0;
        try {
            // �����ǰ����Ϊ�գ��򴴽��µ����ӣ�����ʹ�õ�ǰ����
            if(connection == null){
                getCon();
            }
            // Ҫִ��sql
            String sql = "select community_id from community where community_name=?";
            // ִ��sql �����������������
            exeQuery(sql, cname);
            // ��ȡ��ѯ���
            ResultSet rs = (ResultSet) ps.executeQuery();
            // ����������ڣ���ȡ community_id ֵ
            if (rs.next()) {
                communityid = rs.getInt("community_id");
            }
            System.out.println(communityid);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return communityid;
    }

    //ͨ��loginname�����Ƿ���applyId
    public int getApplyIdByLoginname(String lname){
        int applyid = 0;
        try {
            // �����ǰ����Ϊ�գ��򴴽��µ����ӣ�����ʹ�õ�ǰ����
            if(connection == null){
                getCon();
            }
            // Ҫִ��sql
            String sql = "select applyId from apply where loginname=?";
            // ִ��sql �����������������
            exeQuery(sql, lname);
            // ��ȡ��ѯ���
            ResultSet rs = (ResultSet) ps.executeQuery();
            // ����������ڣ���ȡ community_id ֵ
            if (rs.next()) {
                applyid = rs.getInt("loginname");
            }
            System.out.println(applyid);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return applyid;
    }
}
