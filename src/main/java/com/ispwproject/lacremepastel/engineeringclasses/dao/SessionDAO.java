package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.engineeringclasses.query.SessionQuery;
import com.ispwproject.lacremepastel.model.Login;
import com.ispwproject.lacremepastel.model.Session;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SessionDAO {

    public Session userLogin(Login login) {
        Session ret = null;
        if(login != null){
            try(ResultSet rs = SessionQuery.authUser(Connector.getConnection(),login.getAuthString())){
                //Check user and passwd
                if(rs.next() && (BCrypt.checkpw(login.getPasswd(),rs.getString("password")))){
                    //Correct Passwd
                    ret = new Session(
                        rs.getString("username"),
                        SupportedUserTypes.valueOf(rs.getString("usertype"))
                    );
                }
            }catch (SQLException | IllegalArgumentException e){
                Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());

            }
        }
        return ret;
    }
}
