package com.ispwproject.lecremepastel.other;

import com.ispwproject.lecremepastel.engineeringclasses.bean.NoticeBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.NoticeDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.model.Notice;

import java.util.ArrayList;
import java.util.List;

public class NoticeGenerator {

    private static final String MESSAGE_OK = "Il suo ordine è stato accettato!";
    private static final String MESSAGE_NO = "Il suo ordine è stato rifiutato!";
    private static final String SUBJECT = "Aggiornameto per l'ordine: ";
    private static final String NEW_ORDER = "Nuovo ordine dall'utente: ";

    public Notice finalizedOrderNotice(int orderId, String username, boolean accepted){
        Notice n = new Notice();
        if(accepted){
            n.setSubject(SUBJECT+orderId);
            n.setContent(MESSAGE_OK);
        }else{
            n.setSubject(SUBJECT+orderId);
            n.setContent(MESSAGE_NO);
        }
        return n;
    }

    public Notice createdOrderNotice(String customer, String message){
        Notice n = new Notice();
        n.setSubject(NEW_ORDER+customer);
        n.setContent(message);
        return n;
    }

    public List<NoticeBean> loadNotices(String username) throws IncorrectParametersException {
        if(username == null){
            throw new IncorrectParametersException("NoticeManager::loadNotices: Username can't be null!");
        }
        ArrayList<NoticeBean> noticeList = new ArrayList<>();
        NoticeDAO noticeDAO = new NoticeDAO();
        List<Notice> userNotices = noticeDAO.loadAllUserNotices(username);
        for(Notice n : userNotices){
            noticeList.add(new NoticeBean(
                    n.getId(),
                    n.getSubject(),
                    n.getContent()
            ));
        }
        return noticeList;
    }
}


