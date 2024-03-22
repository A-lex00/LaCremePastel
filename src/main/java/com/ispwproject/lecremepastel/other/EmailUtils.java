package com.ispwproject.lecremepastel.other;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailUtils {

    public boolean checkEmail(String email){
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email);
    }


}
