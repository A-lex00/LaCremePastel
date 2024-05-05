package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.factory.StateFactory;
import com.ispwproject.lacremepastel.engineeringclasses.query.StateQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class StateDAO {

    public AbstractState loadInitialState(){
        AbstractState initialState = null;
        try(ResultSet rs = StateQuery.selectInitialState(Connector.getConnection())){
            if(rs.next()){
                initialState = StateFactory.getInstance().createState(rs.getString("name"));
            }else{
                throw new IllegalStateException("Initial State not found!");
            }
        }catch(SQLException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
            return null;
        }
        loadStateLinks(initialState);
        return initialState;
    }

    public void loadStateLinks(AbstractState state){
        if(state == null){
            return;
        }
        try(ResultSet rs = StateQuery.loadLinks(Connector.getConnection(),state.getStateName())){
            AbstractState link;
            while(rs.next()){
                link = StateFactory.getInstance().createState(rs.getString("name"));
                if (link != null) {
                    state.addState(link);
                }
            }
        }catch (SQLException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }
    }

    public AbstractState loadStateInfo(int id){
        AbstractState loaded = null;
        try(ResultSet rs = StateQuery.loadState(Connector.getConnection(),id)) {
            if(rs.next()){
                loaded = StateFactory.getInstance().createState(rs.getString("name"));
            }
        }catch (SQLException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }
        return loaded;
    }

}
