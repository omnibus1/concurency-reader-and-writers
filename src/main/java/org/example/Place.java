package org.example;

import java.util.ArrayList;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Place{

    int maxUsers;
    ArrayList<String> inLibary=new ArrayList<>();
    ArrayList<String> movingThisTurn=new ArrayList<>();
    BlockingQueue<String>userQue=new ArrayBlockingQueue<>(50);
    int currentUsers=0;
    boolean currentlyMoving=false;
    boolean waiting=false;
    String nextMoving="";

    Place(int n){
        this.maxUsers=n;
    }
    synchronized void join(User user) throws InterruptedException {


            Sleeper.sleep(750);
            Logger.log(Thread.currentThread().getName() + " is trying to join " + getCurrentUsers());
            if (user.getType() == User.Type.READER && userQue.isEmpty() && getCurrentUsers() < maxUsers) {

                movingThisTurn.add(Thread.currentThread().getName());
            } else if (user.getType() == User.Type.WRITER && getCurrentUsers() == 0) {
                movingThisTurn.add(Thread.currentThread().getName());
            } else {
                userQue.add(Thread.currentThread().getName());
            }
            Logger.log(userQue.toString() + " current que");
            Sleeper.sleep(300);
            while (!movingThisTurn.contains(Thread.currentThread().getName())) {
                waiting = true;
                wait();
            }


            if (user.type == User.Type.READER) {
                setCurrentUsers(getCurrentUsers() + 1);
            } else {
                setCurrentUsers(maxUsers);
            }



    }
    synchronized void notifyWaiting() throws InterruptedException {
        if(!userQue.isEmpty()) {

            movingThisTurn.clear();
            if(userQue.peek().startsWith("WRITER")&&getCurrentUsers()!=0){
                Logger.log("NOT NOTIFING NEXT INLINE IS WRITER");
                return;
            }

            if(!userQue.isEmpty()&&userQue.peek().startsWith("USER")){
                int maxIntake=maxUsers-getCurrentUsers();
                while(userQue.peek()!=null&&getCurrentUsers()<maxUsers&&userQue.peek().startsWith("USER")&&maxIntake!=0){
                    maxIntake-=1;
                    String moving=userQue.poll();
                    Logger.log("NOTIFING IN A LOOP "+moving);
                    setNextMovingse(moving);
                    notifyAll();
                    movingThisTurn.add(moving);

                }
                waiting=false;
                setCurrentlyMoving(true);
                return;
            }
            if(userQue.peek().startsWith("WRITER")&&getCurrentUsers()==0){

                String name=userQue.poll();
                setNextMovingse(name);

                Logger.log("SET NEXT TO WRITER "+Thread.currentThread().getName());
                movingThisTurn.add(name);
                notifyAll();
            }


            waiting=false;
        }
    }
    void acquire(User user) throws InterruptedException {
        addToLibary(Thread.currentThread().getName());

        Logger.log(Thread.currentThread().getName()+ " is in the libary "+getInLibary());

        Thread.sleep(1500);
        if(user.type== User.Type.READER){
            setCurrentUsers(getCurrentUsers()-1);
        }
        else{
            setCurrentUsers(0);
        }
        removeFromLibary(Thread.currentThread().getName());
        Logger.log(Thread.currentThread().getName()+ " is leaving "+getInLibary());
        notifyWaiting();
    }
    synchronized int getCurrentUsers(){
        return currentUsers;
    }
    synchronized void setCurrentUsers(int n){
        currentUsers=n;
    }
    void setNextMovingse(String name){
        nextMoving=name;
    }
    String getNextMoving(){
        return nextMoving;
    }
    synchronized String getInLibary(){
        return inLibary.toString();
    }
    synchronized void addToLibary(String name){
        inLibary.add(name);
    }
    synchronized void removeFromLibary(String name){
        inLibary.remove(name);
    }
    synchronized void setCurrentlyMoving(boolean b) throws InterruptedException {
        Sleeper.sleep(250);
        currentlyMoving=b;
    }
    synchronized boolean getCurrentlyMoving(){
        return currentlyMoving;

    }
}
