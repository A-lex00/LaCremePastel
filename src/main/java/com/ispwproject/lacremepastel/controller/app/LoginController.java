package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.LoginBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.RegisterBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.SessionDAO;
import com.ispwproject.lacremepastel.engineeringclasses.factory.SessionDAOFactory;
import com.ispwproject.lacremepastel.model.Login;
import com.ispwproject.lacremepastel.model.Session;

public class LoginController {

    public SessionBean login(LoginBean loginBean){
        SessionBean ret = null;
        if(loginBean != null){
            Login login = new Login(
                    loginBean.getAuthString(),
                    loginBean.getPasswd()
            );
            SessionDAO sessionDAO = SessionDAOFactory.getInstance().createSessionDAO();
            Session session = sessionDAO.userLogin(login);
            if(session != null){
                ret = new SessionBean(session.getUuid());
            }
        }
        return ret;
    }

    public boolean register(RegisterBean registerBean){
        if(registerBean != null){

        }
        return false;
    }

}
