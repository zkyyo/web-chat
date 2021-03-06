package com.zkyyo.www.bean.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 实体类, 对应于数据库中的user
 */
public class FilePo implements Serializable {
    private int fileId; //文件ID
    private int apply; // 文件类型, 0图片分享 1文件分享
    private int userId; //文件上传者ID
    private int topicId; //讨论区ID
    private String path; //相对路径
    private Timestamp created; //发布时间

    public FilePo() {

    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getApply() {
        return apply;
    }

    public void setApply(int apply) {
        this.apply = apply;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "FilePo{" +
                "fileId=" + fileId +
                ", apply=" + apply +
                ", userId=" + userId +
                ", topicId=" + topicId +
                ", path='" + path + '\'' +
                ", created=" + created +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (!(obj instanceof FilePo)) {
            return false;
        }
        FilePo other = (FilePo) obj;
        return fileId == other.getFileId()
                && apply == other.getApply()
                && userId == other.getUserId()
                && topicId == other.topicId
                && path.equals(other.getPath())
                && created.equals(other.getCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileId, apply, userId, topicId, path, created);
    }
}
