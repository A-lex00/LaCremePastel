package com.ispwproject.lecremepastel.engineeringclasses.dao.db;

import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.engineeringclasses.query.WorkerQuery;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lecremepastel.model.User;
import com.ispwproject.lecremepastel.model.Worker;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerDAOdb implements UserDAO {

    private final int USERTYPE = Integer.parseInt(Configurations.getInstance().getProperty("WORKER"));

    @Override
    public User getUser(String username) {
        try(ResultSet rs = WorkerQuery.selectWorker(Connector.getConnection(),username);){
            if (rs.next()) {
                String password = rs.getString("password");
                String firstname = rs.getString("firstname");
                String surname = rs.getString("lastname");
                String email = rs.getString("email");
                String cfPiva = rs.getString("cf-piva");
                String role = rs.getString("role");
                return new Worker(
                        username,
                        password,
                        firstname,
                        surname,
                        email,
                        cfPiva,
                        role
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean registerUser(User u) {
        Worker w = (Worker) u;
        try {
            WorkerQuery.insertWorker(
                    Connector.getConnection(),
                    w.getUsername(),
                    w.getCfPiva(),
                    w.getPasswd(),
                    w.getFirstname(),
                    w.getLastname(),
                    w.getEmail(),
                    w.getRole(),
                    USERTYPE
            );
            return true;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
