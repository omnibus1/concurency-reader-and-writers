package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlaceTest {

    @Test
    public void getUserTest() {
        Place place=new Place(2);
        place.setCurrentUsers(23);
        assertEquals(23,place.getCurrentUsers());
    }

    @Test
    public void nextMovingTest() {
        Place place=new Place(2);
        place.setNextMovingse("ADAS");
        assertEquals("ADAS",place.getNextMoving());
    }
    @Test
    public void generalTest() throws InterruptedException {
        Place place=new Place(1);
        User user=new User(place, User.Type.READER);
        Thread t=new Thread(user,"USER1");
        t.start();
        assertEquals("",place.getNextMoving());
        Sleeper.sleep(2000);
        assertTrue(place.movingThisTurn.contains("USER1"));
    }
    @Test
    public void generalTestV2() throws InterruptedException {
        Place place=new Place(2);
        User user=new User(place, User.Type.READER);
        User user1 =new User(place, User.Type.WRITER);
        Thread t=new Thread(user,"USER1");
        Thread t1=new Thread(user1,"WRITER1");
        t.start();

        t1.start();

        assertTrue(place.userQue.isEmpty());
        Sleeper.sleep(2000);
        assertEquals(1,place.currentUsers);
        assertTrue(place.getInLibary().contains(t.getName()));
        Sleeper.sleep(800);
        assertTrue(place.movingThisTurn.contains(t1.getName()));
    }
    @Test
    public void generalTestV3() throws InterruptedException {
        Place place=new Place(2);
        User user1 =new User(place, User.Type.WRITER);
        User user2=new User(place, User.Type.READER);
        User user3=new User(place, User.Type.READER);
        Thread t1=new Thread(user1,"WRITER1");
        Thread t2=new Thread(user2,"USER2");
        Thread t3=new Thread(user3,"USER3");
        t1.start();
        t2.start();
        t3.start();
        Sleeper.sleep(3800);
        assertTrue(place.movingThisTurn.contains("USER2"));
        assertTrue(place.movingThisTurn.contains("USER3"));

    }
}