package com.ispwproject.lacremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StateQuery {

    private StateQuery(){

    }

    public static ResultSet selectInitialState(Connection conn) throws SQLException {
        String query = "SELECT State.name FROM StateLink JOIN State WHERE StateLink.caller = 0";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            return ps.executeQuery();
        }
    }

}
