package com.jwhbridger.library.glue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ParallelTest1 {
    @Test
    public void test1a() {
        log.info("test1a");
        lookBusy(3000);
        log.info("test1a complete");
    }

    @Test
    public void test1b() {
        log.info("test1b");
        lookBusy(3000);
        log.info("test1b complete");
    }

    public static void lookBusy(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }
}
