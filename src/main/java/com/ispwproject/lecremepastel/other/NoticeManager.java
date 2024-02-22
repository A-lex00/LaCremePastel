package com.ispwproject.lecremepastel.other;

import com.ispwproject.lecremepastel.engineeringclasses.bean.NoticeBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.NoticeDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.exception.InvalidSessionException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lecremepastel.model.Notice;

import java.util.ArrayList;
import java.util.List;

public class NoticeManager {

    private static final String MESSAGE_OK = "Il suo ordine è stato accettato!";
    private static final String MESSAGE_NO = "Il suo ordine è stato rifiutato!";
    private static final String SUBJECT = "Aggiornameto per l'ordine: ";
    private static final String NEW_ORDER = "Nuovo ordine dall'utente: ";

    public void finalizedOrderNotice(int orderId, String username, boolean accepted){
        NoticeDAO noticeDAO = new NoticeDAO();
        if(accepted){
            noticeDAO.saveNotice(new Notice(
                    SUBJECT+orderId,
                    MESSAGE_OK,
                    false
            ),username);
        }else{
            noticeDAO.saveNotice(new Notice(
                    SUBJECT+orderId,
                    MESSAGE_NO,
                    false
            ),username);
        }
    }

    public void createdOrderNotice(String customer){
        NoticeDAO noticeDAO = new NoticeDAO();
        noticeDAO.directorNotice(new Notice(
                NEW_ORDER+customer,
                "",
                false
        ));
    }

    public List<NoticeBean> loadNotices(String sid) throws InvalidSessionException, IncorrectParametersException {
        if(sid == null){
            throw new InvalidSessionException("NoticeManager::loadNotices: Invalid Session ID!");
        }
        SessionBean sessionBean = SessionManager.getInstance().getSession(sid);
        if(sessionBean == null){
            throw new InvalidSessionException("NoticeManager::loadNotices: Invalid Session ID!");
        }
        ArrayList<NoticeBean> noticeList = new ArrayList<>();
        String username = sessionBean.getUsername();
        NoticeDAO noticeDAO = new NoticeDAO();
        List<Notice> userNotices = noticeDAO.loadAllUserNotices(username);
        for(Notice n : userNotices){
            noticeList.add(new NoticeBean(
                    n.getId(),
                    n.getSubject(),
                    n.getContent(),
                    n.isRead()
            ));
        }
        return noticeList;
    }
}


