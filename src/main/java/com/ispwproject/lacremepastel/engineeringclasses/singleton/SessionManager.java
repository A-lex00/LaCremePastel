package com.ispwproject.lacremepastel.engineeringclasses.singleton;

import com.ispwproject.lacremepastel.engineeringclasses.exception.SessionNotFoundException;
import com.ispwproject.lacremepastel.model.Session;

import java.util.Date;
import java.util.HashMap;

public class SessionManager {

    private static SessionManager instance = null;
    private final HashMap<String, Session> loggedUsers;

    private SessionManager(){
        loggedUsers = new HashMap<>();
    }

    public static synchronized SessionManager getInstance(){
        if(instance == null){
            instance = new SessionManager();
        }
        return instance;
    }

    public void addSession(Session session){
        if(session != null && !loggedUsers.containsKey(session.getUuid())){
                loggedUsers.put(session.getUuid(),session);
        }
    }

    public Session delSession(String uuid) throws SessionNotFoundException{
        Session ret = null;
        if(uuid != null){
            if(loggedUsers.containsKey(uuid)){
                ret = loggedUsers.remove(uuid);
            }else{
                throw new SessionNotFoundException("Session "+uuid+"not found");
            }
        }
        return ret;
    }

    public boolean checkSession(String uuid) throws SessionNotFoundException {
        if(uuid != null){
            Session session = loggedUsers.get(uuid);
            if(session != null){
                //Verify expire date
                Date now = new Date();
                if(session.getExpire().before(now)){
                    //Session expired!
                    delSession(session.getUuid());
                    return false;
                }else{
                    //Session still valid
                    session.refresh();
                    return true;
                }
            }else{
                throw new SessionNotFoundException("Session "+uuid+"not found");
            }
        }
        return false;
    }


}
