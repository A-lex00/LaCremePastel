package com.ispwproject.lecremepastel.engineeringclasses.singleton;

import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.model.Session;
import java.util.HashMap;
import java.util.UUID;

public class SessionManager {

    private final HashMap<String, Session> activeUsers = new HashMap<>();
    private static SessionManager instance = null;

    public static SessionManager getInstance(){
        if(instance == null){
            instance = new SessionManager();
        }
        return instance;
    }

    public SessionBean getSession(String sid){

        Session s = activeUsers.get(sid);
        if(s != null){
            try{
                return new SessionBean(
                        s.getUsername(),
                        s.getHashedPasswd(),
                        s.getUserType()
                );
            }catch (IncorrectParametersException e){
                e.fillInStackTrace();
            }
        }
        return null;
    }

    public String addSession(Session session) {
        String uuid = UUID.randomUUID().toString();
        activeUsers.put(uuid,session);
        return uuid;
    }

    public void delSession(String sid){
        activeUsers.remove(sid);
    }
}
