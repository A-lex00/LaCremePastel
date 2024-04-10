package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.LoginBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.RegisterBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.SessionDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyLoggedException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UuidAlreadyExistent;
import com.ispwproject.lacremepastel.engineeringclasses.factory.SessionDAOFactory;
import com.ispwproject.lacremepastel.engineeringclasses.factory.UserDAOFactory;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lacremepastel.model.Login;
import com.ispwproject.lacremepastel.model.Register;
import com.ispwproject.lacremepastel.model.Session;

public class LoginController {

    public SessionBean login(LoginBean loginBean)  {
        SessionBean ret = null;
        if(loginBean != null){
            Login login = new Login(
                    loginBean.getAuthString(),
                    loginBean.getPasswd()
            );
            SessionDAO sessionDAO = SessionDAOFactory.getInstance().createSessionDAO();
            Session session = sessionDAO.userLogin(login);
            try {
                SessionManager.getInstance().addSession(session);
            } catch (UserAlreadyLoggedException e) {
                throw new RuntimeException(e);
            } catch (UuidAlreadyExistent e) {
                throw new RuntimeException(e);
            }
            if(session != null){
                ret = new SessionBean(session.getUuid());
            }
        }
        return ret;
    }

    public boolean register(RegisterBean registerBean){
        if(registerBean != null){
            Register register = new Register(
                    registerBean.getUsername(),
                    registerBean.getCfPiva(),
                    registerBean.getPasswd(),
                    registerBean.getFirstname(),
                    registerBean.getLastname(),
                    registerBean.getEmail(),
                    registerBean.getUserType()
            );

        }
        return false;
    }

}
