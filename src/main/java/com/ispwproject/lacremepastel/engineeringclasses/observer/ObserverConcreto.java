package com.ispwproject.lacremepastel.engineeringclasses.observer;

public class ObserverConcreto extends Observer {
    private String id;
    private boolean stato;      //stato dell'osservatore
    private Soggetto soggetto;
    public ObserverConcreto(String id,Soggetto soggetto){
        this.id = id;
        this.soggetto = soggetto;
        this.stato= false;
    }

    @Override
    public void update() {
        stato= soggetto.getStato();
    }
    public void setUpdatePeriod(int timeOut){
        this.timeOut = timeOut;
    }

}
