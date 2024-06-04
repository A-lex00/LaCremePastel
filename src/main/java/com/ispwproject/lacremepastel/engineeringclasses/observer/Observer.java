package com.ispwproject.lacremepastel.engineeringclasses.observer;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.model.OrderLine;
/** verrà usata come classe astratta implementata dai ConcreteObserver che realizzeranno update*/

public interface  Observer {
    void update();
}
