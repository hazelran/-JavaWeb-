package com.shetuan.bean;

public class Apply {

    private String loginName;
    private int communityId;
    private String member_name;
    private String member_gender;
    private String member_grade;
    private String member_institute;
    private String community_name;



    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_gender() {
        return member_gender;
    }

    public void setMember_gender(String member_gender) {
        this.member_gender = member_gender;
    }

    public String getMember_grade() {
        return member_grade;
    }

    public void setMember_grade(String member_grade) {
        this.member_grade = member_grade;
    }

    public String getMember_institute() {
        return member_institute;
    }

    public void setMember_institute(String member_institute) {
        this.member_institute = member_institute;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    @Override
    public String toString() {
        return "Apply{" +
                ", loginName='" + loginName + '\'' +
                ", communityId=" + communityId +
                ", member_name='" + member_name + '\'' +
                ", member_gender='" + member_gender + '\'' +
                ", member_grade='" + member_grade + '\'' +
                ", member_institute='" + member_institute + '\'' +
                ", community_name='" + community_name + '\'' +
                '}';
    }

}
