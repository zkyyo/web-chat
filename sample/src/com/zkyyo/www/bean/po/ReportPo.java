package com.zkyyo.www.bean.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 实体类, 对应于数据库中的report
 */
public class ReportPo implements Serializable {
    private int reportId; //举报ID
    private int userId; //举报者ID
    private int contentId; //举报内容ID
    private int contentType; // 0举报发言, 1举报分享图片, 3举报分享文件
    private String reason; //原因
    private Timestamp created; //举报时间

    public ReportPo() {

    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
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
        if (!(obj instanceof ReportPo)) {
            return false;
        }
        ReportPo other = (ReportPo) obj;
        return reportId == other.getReportId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId);
    }

    @Override
    public String toString() {
        return "ReportPo{" +
                "reportId=" + reportId +
                ", userId=" + userId +
                ", contentId=" + contentId +
                ", contentType=" + contentType +
                ", reason='" + reason + '\'' +
                ", created=" + created +
                '}';
    }
}
