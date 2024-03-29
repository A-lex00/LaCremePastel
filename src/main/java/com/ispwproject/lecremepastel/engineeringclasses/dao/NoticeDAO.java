package com.ispwproject.lecremepastel.engineeringclasses.dao;

import com.ispwproject.lecremepastel.engineeringclasses.query.NoticeQuery;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lecremepastel.model.Notice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {

    public Notice loadUserNotice(int id, String username){
        try(ResultSet rs = NoticeQuery.selectUserNotice(Connector.getConnection(),id,username)){
            if(rs.next()){
                String subject = rs.getString("subject");
                String content = rs.getString("content");
                Boolean read = rs.getBoolean("isRead");
                return new Notice(id, subject, content, read);
            }
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        return null;
    }

    public List<Notice> loadAllUserNotices(String username){
        ArrayList<Notice> list = new ArrayList<>();
        try(ResultSet rs = NoticeQuery.selectAllUserNotice(Connector.getConnection(),username)){
            while(rs.next()){
                int id = rs.getInt(("id"));
                String content = rs.getString("content");
                String subject = rs.getString("subject");
                Boolean read = rs.getBoolean("isRead");
                list.add(new Notice(id,subject,content,read));
            }
        }catch (SQLException ex){
            ex.fillInStackTrace();
        }
        return list;
    }

    public boolean deleteUserNotice(int noticeId){
        try{
            NoticeQuery.deleteUserNotice(Connector.getConnection(),noticeId);
            return true;
        }catch(SQLException ex){
            ex.fillInStackTrace();
        }
        return false;
    }

    public boolean deleteAllUserNotices(String username){
        try{
            NoticeQuery.deleteAllUserNotice(Connector.getConnection(),username);
            return true;
        }catch(SQLException ex){
            ex.fillInStackTrace();
        }
        return false;
    }

    public boolean saveNotice(Notice n, String username){
        try{
            NoticeQuery.insertUserNotice(Connector.getConnection(),n.getSubject(),n.getContent(),username);
            return true;
        }catch(SQLException ex){
            ex.fillInStackTrace();
        }
        return false;
    }

    public boolean markAsRead(int noticeId){
        try{
            NoticeQuery.markAsRead(Connector.getConnection(),noticeId);
            return true;
        }catch(SQLException ex){
            ex.fillInStackTrace();
        }
        return false;
    }

    public boolean directorNotice(Notice n){
        try{
            NoticeQuery.insertDirectorNotice(Connector.getConnection(), n.getSubject(), n.getContent());
            return true;
        }catch(SQLException e){
            e.fillInStackTrace();
            System.err.println(e.getMessage());
        }
        return false;
    }
}
