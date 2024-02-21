package com.ispwproject.lecremepastel.engineeringclasses.dao.db;

import com.ispwproject.lecremepastel.engineeringclasses.dao.LoginDAO;
import com.ispwproject.lecremepastel.engineeringclasses.query.LoginQuery;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lecremepastel.model.Session;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOdb implements LoginDAO {

    public Session loginUser(String authString) {
        Session session = null;
        try (ResultSet rs = LoginQuery.selectUser(Connector.getConnection(),authString);){
            if (rs.next()) {
                session = new Session(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("usertype")
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return session;
    }
}
