package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.NoticeBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.NoticeDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.exception.InvalidSessionException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lecremepastel.model.Notice;

import java.util.ArrayList;
import java.util.List;

public class ManageUserInfoController {

    public List<NoticeBean> getUserNotices(String sid) throws InvalidSessionException {
        SessionBean sessionBean = SessionManager.getInstance().getSession(sid);
        if(sessionBean == null){
            throw new InvalidSessionException("ManageUserInfoController::getUserNotices: Invalid Session ID!");
        }
        NoticeDAO noticeDAO = new NoticeDAO();
        List<Notice> noticeList = noticeDAO.loadAllUserNotices(sessionBean.getUsername());
        ArrayList<NoticeBean> beanList = new ArrayList<>();
        for(Notice n : noticeList){
            try {
                beanList.add(new NoticeBean(
                        n.getId(),
                        n.getSubject(),
                        n.getContent(),
                        n.isRead()
                ));
            }catch(IncorrectParametersException e){
                e.fillInStackTrace();
                System.err.println("Cannot load notice with ID: "+n.getId());
            }
        }
        return beanList;
    }

}
