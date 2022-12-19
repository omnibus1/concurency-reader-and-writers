package org.example;

/**
 * Main class used to run our program
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Place place=new Place(5);
        User u1=new User(place,User.Type.READER);
        User u2=new User(place,User.Type.READER);
        User u3=new User(place,User.Type.READER);
        User u4=new User(place,User.Type.READER);
        User u5=new User(place,User.Type.READER);
        User u6=new User(place,User.Type.READER);
        User u7=new User(place,User.Type.READER);
        User u8=new User(place,User.Type.READER);
        User u9=new User(place,User.Type.READER);
        User u10=new User(place,User.Type.READER);
        User u11=new User(place,User.Type.WRITER);
        User u12=new User(place,User.Type.WRITER);
        User u13=new User(place,User.Type.WRITER);

        Thread t1=new Thread(u1,"USER1");
        Thread.sleep(50);
        Thread t2=new Thread(u2,"USER2");
        Thread.sleep(50);

        Thread t3=new Thread(u3,"USER3");
        Thread.sleep(50);
        Thread t4=new Thread(u4,"USER4");
        Thread.sleep(50);
        Thread t5=new Thread(u5,"USER5");
        Thread.sleep(50);
        Thread t6=new Thread(u6,"USER6");
        Thread t7=new Thread(u7,"USER7");

        Thread t8=new Thread(u8,"USER8");

        Thread t9=new Thread(u9,"USER9");

        Thread t10=new Thread(u10,"USER10");

        Thread t11=new Thread(u11,"WRITER1");

        Thread t12=new Thread(u12,"WRITER2");
        Thread t13=new Thread(u13,"WRITER3");

        t1.start();
        Thread.sleep(500);
        t2.start();
        Thread.sleep(500);
        t3.start();
        Thread.sleep(500);
        t12.start();
        Thread.sleep(500);
        t4.start();
        Thread.sleep(500);
        t5.start();
        Thread.sleep(500);
        t10.start();
        Thread.sleep(500);
        t6.start();
        Thread.sleep(500);
        t7.start();
        Thread.sleep(500);
        t8.start();
        Thread.sleep(500);
        t11.start();
        Thread.sleep(500);
        t9.start();
        Thread.sleep(500);
        t13.start();





    }
}