package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.LoginBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.RegisterBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.LoginDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.factory.persistence.LoginDAOFactory;
import com.ispwproject.lecremepastel.engineeringclasses.factory.persistence.UserDAOFactory;
import com.ispwproject.lecremepastel.engineeringclasses.factory.users.UserFactory;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lecremepastel.model.Login;
import com.ispwproject.lecremepastel.model.Register;
import com.ispwproject.lecremepastel.model.Session;
import com.ispwproject.lecremepastel.model.User;
import org.mindrot.jbcrypt.BCrypt;
import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;

public class LoginController {

    /**
     *
     * @param registerBean Bean with all necessary data for a new User's registration
     * @return true if the operation terminated correctly, false otherwise
     * @throws IncorrectParametersException Thrown only if data is not valid
     */
    public boolean register(RegisterBean registerBean) throws IncorrectParametersException {
        if(registerBean != null){
            Register register = new Register(
                    registerBean.getEmail(),
                    registerBean.getUsername(),
                    registerBean.getFirstname(),
                    registerBean.getSurname(),
                    registerBean.getPassword(),
                    registerBean.getCfPiva(),
                    registerBean.getRole(),
                    registerBean.getBillingAddress(),
                    registerBean.getUserType()
            );
            //Hash password
            register.setPassword(BCrypt.hashpw(register.getPassword(), BCrypt.gensalt()));
            //User creation
            User user = UserFactory.getFactory(register.getUserType()).createUser(register);
            //Make User Persistent
            UserDAO dao = UserDAOFactory.getFactory(register.getUserType()).createDAO();
            return dao.registerUser(user);
        }
        return false;
    }

    /**
     *
     * @param loginBean Bean with User's credentials
     * @return String representing logged User's Session ID or null if login failed
     * @throws IncorrectParametersException Thrown only if data is not valid
     */
    public String login(LoginBean loginBean) throws IncorrectParametersException {
        if(loginBean != null){
            //Load credentials
            Login login = new Login(
              loginBean.getAuthString(),
              loginBean.getPasswd()
            );
            LoginDAO ld = LoginDAOFactory.getFactory().createDAO();
            Session session = ld.loginUser(login.getAuthString());

            //Check login e set active session
            if(session != null && BCrypt.checkpw(login.getPasswd(),session.getHashedPasswd())){
                return SessionManager.getInstance().addSession(session);
            }
        }
        //Login Failed
        return null;
    }

}
