package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.NoticeBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.exception.InvalidSessionException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;

public class HelpController {

    public void requestHelp(String sid, NoticeBean noticeBean) throws IncorrectParametersException, InvalidSessionException {
        if(noticeBean == null){
            throw new IncorrectParametersException("HelpController::requestHelp: NoticeBean can't be null");
        }
        SessionBean sessionBean = SessionManager.getInstance().getSession(sid);
        if(sessionBean == null){
            throw new InvalidSessionException("HelpController::requestHelp: Invalid Session ID!");
        }


    }

}
