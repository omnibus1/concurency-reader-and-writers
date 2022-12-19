package org.example;

class User implements Runnable{
    boolean wantToExit=false;
    Place place;
    Type type;
    enum Type{
        WRITER,READER;
    }
    User(Place place,Type type){
        this.place=place;
        setType(type);
    }
    @Override
    public void run() {
        while(!wantToExit){
            try {
                place.join(this);
                place.acquire(this);
            } catch (InterruptedException e) {
                Logger.log("INTERRUPTED");
                Thread.currentThread().interrupt();
                return;

            }
            try {
                Sleeper.sleep(2500);
            } catch (InterruptedException e) {
                Logger.log("INTERRUPTED");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
    Type getType(){
        return this.type;
    }
    void setType(Type newType){
        this.type=newType;
    }
}