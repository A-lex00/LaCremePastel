package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.LoginBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.RegisterBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.SessionDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyExistentException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyLoggedException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UuidAlreadyExistent;
import com.ispwproject.lacremepastel.engineeringclasses.factory.SessionDAOFactory;
import com.ispwproject.lacremepastel.engineeringclasses.factory.UserDAOFactory;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lacremepastel.model.Login;
import com.ispwproject.lacremepastel.model.Register;
import com.ispwproject.lacremepastel.model.Session;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;

import java.util.logging.Logger;

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
            SessionManager.getInstance().addSession(session);
            if(session != null){
                ret = new SessionBean(session.getUuid());
            }
        }
        return ret;
    }

    public boolean register(RegisterBean registerBean) throws UserAlreadyExistentException {
        if(registerBean != null){
            Register register = null;
            try {
                register = new Register(
                        registerBean.getUsername(),
                        registerBean.getCfPiva(),
                        registerBean.getPasswd(),
                        registerBean.getFirstname(),
                        registerBean.getLastname(),
                        registerBean.getEmail(),
                        SupportedUserTypes.valueOf(registerBean.getUserType())
                );
            }catch (IllegalArgumentException e){
                Logger.getLogger(LoginController.class.getName()).severe("Unsupported User Type: "+registerBean.getUserType());
                return false;
            }

            UserDAOFactory userDAOFactory = UserDAOFactory.getInstance();
            UserDAO userDAO = userDAOFactory.getFactory(register.getUserType());
            userDAO.userRegister(register);
            return true;
        }
        return false;
    }

}
