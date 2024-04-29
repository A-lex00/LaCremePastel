package com.ispwproject.lacremepastel.engineeringclasses.observer;

public abstract class  Observer implements  Runnable {
    private boolean state;
    protected boolean isAlive;
    protected int timeOut;

    protected Observer() {
        this.isAlive = false;
    }

    @Override
    public void run() {
        this.isAlive = true;
        while (this.isAlive){
            this.update();
            try {
                Thread.sleep(this.timeOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.err.println("Observer Error!");
            }
        }
    }

    public void stopObservation() {
        this.isAlive = false;
    }

    protected void notifySubjectStatus(String message) {
        System.out.println(message);
    }

    public abstract void update();

}
