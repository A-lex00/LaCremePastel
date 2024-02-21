package com.ispwproject.lecremepastel.engineeringclasses.dao;

import com.ispwproject.lecremepastel.model.Session;

public interface LoginDAO {

    Session loginUser(String authString);

}
