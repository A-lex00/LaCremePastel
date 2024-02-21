package com.ispwproject.lecremepastel.other;

import com.ispwproject.lecremepastel.model.Notice;

public class NoticeManager {
        private int idOrder;
        public void acceptNotice(Integer id, String username){

            this.idOrder=id;
            String message= "Il suo ordine è stato accettato";
            String subject="Aggiornamento per l'ordine con ";
            Notice notice=new Notice(idOrder,subject,message,false);
        }
    public void rejectNotice(Integer id, String username){
            this.idOrder=id;
            String message= "Il suo ordine è stato rifiutato";
            String subject="Aggiornamento per l'ordine con id"+idOrder;
            Notice notice=new Notice(idOrder,subject,message,false);
    }
}


