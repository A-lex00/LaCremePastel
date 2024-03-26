package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.model.Notice;

//So che potrebbe non essere una factory, ma volevo proporti la cosa
public class NoticeFactory {

    public Notice createFinalizedOrderNotice(int orderId, boolean accepted){
        StringBuilder subject = new StringBuilder();
        subject.append("Ordine ");
        subject.append(orderId);
        if(accepted){
            subject.append(" accettato!");
        }else{
            subject.append(" rifiutato!");
        }
        return new Notice(
                -1,
                subject.toString(),
                "",
                false
        );
    }

    public Notice createdOrderNotice(String customer, String message){
        throw new UnsupportedOperationException();
    }

    public Notice createHelpNotice(String customer, String subject, String content){
        throw new UnsupportedOperationException();
    }

}
