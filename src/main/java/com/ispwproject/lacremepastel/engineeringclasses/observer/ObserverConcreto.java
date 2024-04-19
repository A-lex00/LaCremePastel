package com.ispwproject.lacremepastel.engineeringclasses.observer;

public class ObserverConcreto implements  Observer {
    private String id;
    private boolean stato;      //stato dell'osservatore
    private Soggetto soggetto;
    public ObserverConcreto(String id,Soggetto soggetto){
        this.id=id;
        this.soggetto=soggetto;
        this.stato= false;
    }
    @Override
    public void aggiorna() {
        stato= soggetto.getStato();
    }
}
