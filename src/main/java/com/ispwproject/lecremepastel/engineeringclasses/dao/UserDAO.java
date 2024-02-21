package com.ispwproject.lecremepastel.engineeringclasses.dao;

import com.ispwproject.lecremepastel.model.User;

public interface UserDAO {

    boolean registerUser(User u);
    User getUser(String username);
}
