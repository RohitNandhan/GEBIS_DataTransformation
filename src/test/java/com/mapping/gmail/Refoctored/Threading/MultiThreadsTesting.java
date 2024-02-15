package com.mapping.gmail.Refoctored.Threading;

import org.junit.jupiter.api.Test;

public class MultiThreadsTesting extends Thread {


    @Test
    public void multiThreadsTest() {

        Thread t1 = new MultiThreadsTesting();
        t1.start();
        Thread t2 = new MultiThreadsTesting();
        t2.start();


    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + ": Count " + i);
            try {
                Thread.sleep(1); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
