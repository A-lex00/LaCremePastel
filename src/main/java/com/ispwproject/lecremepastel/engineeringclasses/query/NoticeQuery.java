package com.ispwproject.lecremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeQuery {

    private NoticeQuery(){
        throw new IllegalStateException("NoticeQuery: Utility class");
    }

    public static ResultSet selectUserNotice(Connection conn, int noticeId, String username) throws SQLException{
        String sql = "SELECT id,subject,content,isRead FROM Notice WHERE id = ? AND user = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,noticeId);
            ps.setString(2,username);
            return ps.executeQuery();
        }
    }

    public static ResultSet selectAllUserNotice(Connection conn, String username) throws SQLException{
        String sql = "SELECT id,subject,content,isRead FROM Notice WHERE user = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,username);
            return ps.executeQuery();
        }
    }

    public static void deleteUserNotice(Connection conn, int noticeId) throws SQLException{
        String sql = "DELETE FROM Notice WHERE id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,noticeId);
            ps.executeUpdate();
        }
    }

    public static void deleteAllUserNotice(Connection conn, String username) throws SQLException{
        String sql = "DELETE FROM Notice WHERE user = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,username);
            ps.executeUpdate();
        }
    }

    public static void insertUserNotice(Connection conn, String subject, String content, String username) throws SQLException{
        String sql = "INSERT INTO Notice(subject,content,user) VALUES (?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,subject);
            ps.setString(2,content);
            ps.setString(3,username);
            ps.executeUpdate();
        }
    }

    public static void markAsRead(Connection conn, int noticeId) throws SQLException{
        String sql = "UPDATE Notice SET isRead = 1 WHERE id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,noticeId);
            ps.executeUpdate();
        }
    }
}
