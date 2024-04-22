package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.query.StateQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class StateDAO {

    public AbstractState loadInitialState(){
        AbstractState initialState = null;
        try(ResultSet rs = StateQuery.selectInitialState(Connector.getConnection())){
            if(rs.next()){
                //Come istanzio il giusto tipo di stato senza infrangere Demetra?
                //Davvero non ho altro modo che passare per una factory o Abstract Factory?
            }
        }catch(SQLException e){
            Logger.getLogger("StateDAO").severe(e.getMessage());
        }
        return initialState;
    }

}
