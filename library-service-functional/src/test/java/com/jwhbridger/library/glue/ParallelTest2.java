package com.jwhbridger.library.glue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ParallelTest2 {
    @Test
    public void test2a() {
        log.info("tes21a");
        lookBusy(3000);
        log.info("tes21a complete");
    }

    @Test
    public void test2b() {
        log.info("test2b");
        lookBusy(3000);
        log.info("test2b complete");
    }

    public static void lookBusy(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }
}
