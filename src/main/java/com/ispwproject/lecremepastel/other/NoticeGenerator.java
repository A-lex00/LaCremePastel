package com.ispwproject.lecremepastel.other;

import com.ispwproject.lecremepastel.model.Notice;
import com.ispwproject.lecremepastel.other.NoticeStrings;
public class NoticeGenerator {


    public Notice finalizedOrderNotice(int orderId, boolean accepted){
        Notice n = new Notice();
        if(accepted){
            n.setSubject(NoticeStrings.SUBJECT+orderId);
            n.setContent(NoticeStrings.MESSAGE_OK);
        }else{
            n.setSubject(NoticeStrings.SUBJECT+orderId);
            n.setContent(NoticeStrings.MESSAGE_NO);
        }
        return n;
    }

    public Notice createdOrderNotice(String customer, String message){
        Notice n = new Notice();
        n.setSubject(NoticeStrings.NEW_ORDER+customer);
        n.setContent(message);
        return n;
    }

    public Notice helpNotice(String customer, String subject, String content){
        Notice n = new Notice();
        n.setSubject(NoticeStrings.HELP+customer+": "+subject);
        n.setContent(content);
        return n;
    }
}


