package com.zkyyo.www.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReplyPo implements Serializable {
    private int replyId;
    private int topicId;
    private int userId;
    private String content;
    private int contentType; // 0文本 1图片
    private Timestamp created;

    public ReplyPo() {

    }

    public ReplyPo(int replyId, int topicId, int userId, String content, int contentType, Timestamp created) {
        this.replyId = replyId;
        this.topicId = topicId;
        this.userId = userId;
        this.content = content;
        this.contentType = contentType;
        this.created = created;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "ReplyPo{" +
                "replyId=" + replyId +
                ", topicId=" + topicId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", contentType=" + contentType +
                ", created=" + created +
                '}';
    }
}
