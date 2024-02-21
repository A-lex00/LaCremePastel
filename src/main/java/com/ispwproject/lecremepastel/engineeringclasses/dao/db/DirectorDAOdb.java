package com.ispwproject.lecremepastel.engineeringclasses.dao.db;

import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.engineeringclasses.query.DirectorQuery;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lecremepastel.model.Director;
import com.ispwproject.lecremepastel.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorDAOdb implements UserDAO {

    private static final int USERTYPE = Integer.parseInt(Configurations.getInstance().getProperty("DIRECTOR"));

    @Override
    public boolean registerUser(User u) {
        Director d = (Director) u;
        try {
            DirectorQuery.insertDirector(
                    Connector.getConnection(),
                    d.getUsername(),
                    d.getCfPiva(),
                    d.getPasswd(),
                    d.getFirstname(),
                    d.getLastname(),
                    d.getEmail(),
                    USERTYPE
            );
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(String username) {

        try (ResultSet rs = DirectorQuery.selectDirector(Connector.getConnection(), username)){
            if(rs.next()) {
                String finalUsername = rs.getString("username");
                String firstname = rs.getString("firstname");
                String surname = rs.getString("lastname");
                String email = rs.getString("email");
                String cfPiva = rs.getString("cf-piva");
                return new Director(
                        finalUsername,
                        firstname,
                        surname,
                        email,
                        cfPiva
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
