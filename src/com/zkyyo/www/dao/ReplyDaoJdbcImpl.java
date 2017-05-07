package com.zkyyo.www.dao;

import com.zkyyo.www.db.DbClose;
import com.zkyyo.www.po.ReplyPo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReplyDaoJdbcImpl implements ReplyDao{
    private DataSource dataSource;

    public ReplyDaoJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addReply(ReplyPo replyPo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            String sql = "INSERT INTO reply (topic_id, user_id, content, content_type) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, replyPo.getTopicId());
            pstmt.setInt(2, replyPo.getUserId());
            pstmt.setString(3, replyPo.getContent());
            pstmt.setInt(4, replyPo.getContentType());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbClose.close(conn, pstmt);
        }
    }

    @Override
    public List<ReplyPo> selectReplysByTopicId(int topicId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ReplyPo> replys = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM reply WHERE topic_id=? ORDER BY created";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, topicId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int replyId = rs.getInt("reply_id");
                int userId = rs.getInt("user_id");
                String content = rs.getString("content");
                int contentType = rs.getInt("content_type");
                Timestamp created = rs.getTimestamp("created");
                replys.add(new ReplyPo(replyId, topicId, userId, content, contentType, created));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbClose.close(conn, pstmt, rs);
        }
        return replys;
    }

    @Override
    public ReplyPo selectReplyByReplyId(int replyId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM reply WHERE reply_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, replyId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                ReplyPo reply = new ReplyPo();
                reply.setReplyId(replyId);
                reply.setTopicId(rs.getInt("topic_id"));
                reply.setUserId(rs.getInt("user_id"));
                reply.setContent(rs.getString("content"));
                reply.setContentType(rs.getInt("content_type"));
                reply.setCreated(rs.getTimestamp("created"));
                return reply;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbClose.close(conn, pstmt, rs);
        }
        return null;
    }

    @Override
    public void deleteReply(int replyId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            String sql = "DELETE FROM reply WHERE reply_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, replyId);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbClose.close(conn, pstmt);
        }
    }
}
