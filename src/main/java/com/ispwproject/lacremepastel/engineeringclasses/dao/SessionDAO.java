package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.model.Login;
import com.ispwproject.lacremepastel.model.Session;

public interface SessionDAO {
    Session userLogin(Login login);
}
