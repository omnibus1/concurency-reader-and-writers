package org.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void getType() {
        Place place=new Place(2);
        User user=new User(place, User.Type.WRITER);
        assertEquals(User.Type.WRITER,user.getType());
    }

    @Test
    public void setType() {
        Place place=new Place(2);
        User user=new User(place, User.Type.WRITER);
        user.setType(User.Type.READER);
        assertEquals(User.Type.READER,user.getType());
    }
    @Test
    public void runTest() throws InterruptedException {
        Place place=new Place(2);
        User user=new User(place, User.Type.READER);
        Thread t=new Thread(user,"USER1");
        t.start();
        Sleeper.sleep(2000);
        assertEquals(1,place.currentUsers);

    }
    @Test
    public void interruptTest(){
        Place place=new Place(2);
        User user=new User(place, User.Type.READER);
        Thread t=new Thread(user,"USER1");
        t.start();
        t.interrupt();
        assertEquals(true,t.isAlive());


    }
}
