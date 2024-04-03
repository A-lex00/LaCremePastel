package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.engineeringclasses.dao.SessionDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.db.SessionDbDAO;

public class SessionDbFactory extends SessionDAOFactory{
    @Override
    public SessionDAO createSessionDAO() {
        return new SessionDbDAO();
    }
}
