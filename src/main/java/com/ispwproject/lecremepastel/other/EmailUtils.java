package com.ispwproject.lecremepastel.other;

import java.util.regex.Pattern;

public class EmailUtils {

    private static final String REGEX = "^(.*)@(\\S*)$";

    public boolean checkEmail(String email){
        if(email != null){
            return Pattern.compile(REGEX).matcher(email).matches();
        }
        return false;
    }
}
