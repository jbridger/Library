package com.jwhbridger.library.glue;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

public class ParallelRunnerGroup1AB {

    @Test
    public void runAllTests() {
        Class<?>[] classes = { Group1ATests.class, Group1BTests.class };

        // ParallelComputer(true,true) will run all classes and methods
        // in parallel.  (First arg for classes, second arg for methods)
        JUnitCore.runClasses(new ParallelComputer(true, false), classes);
    }
}
