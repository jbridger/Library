package com.jwhbridger.library.glue;

import org.junit.Test;

public class ParallelTest2 {
    @Test
    public void test2a() {
        lookBusy(3000);
    }

    @Test
    public void test2b() {
        lookBusy(3000);
    }

    public static void lookBusy(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }
}
