package com.example.ji.smartclothes.bean;

import cn.bmob.v3.BmobObject;

public class FeedBackBean extends BmobObject {

    private long creatTimeAsId;
    private String feedbackContent;
    private String userName;

    public long getCreatTimeAsId() {
        return creatTimeAsId;
    }

    public void setCreatTimeAsId(long creatTimeAsId) {
        this.creatTimeAsId = creatTimeAsId;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "FeedBackBean{" +
                "creatTimeAsId=" + creatTimeAsId +
                ", feedbackContent='" + feedbackContent + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
