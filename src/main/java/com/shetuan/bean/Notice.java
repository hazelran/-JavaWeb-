package com.shetuan.bean;

public class Notice {
    private int noticeId;
    private String noticeName;
    private String noticeIntroduction;
    private String noticeTime;
    private int communityId;
    private String communityName;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeIntroduction() {
        return noticeIntroduction;
    }

    public void setNoticeIntroduction(String noticeIntroduction) {
        this.noticeIntroduction = noticeIntroduction;
    }

    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", noticeName='" + noticeName + '\'' +
                ", noticeIntroduction='" + noticeIntroduction + '\'' +
                ", noticeTime='" + noticeTime + '\'' +
                ", communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                '}';
    }
}
