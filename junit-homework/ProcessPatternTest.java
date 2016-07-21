package com.endava.junit.process.test;

import com.endava.junit.process.ProcessPattern;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by tvasile on 7/21/2016.
 */
public class ProcessPatternTest {

    ProcessPattern testPattern;

    @Before
    public void setUp() {
        testPattern = new ProcessPattern();
    }

    @Test
    public void generatePositionUnknownPositionTest() {
        Assert.assertEquals(testPattern.generatePosition("Pensioned", 40), "Unknown Position");
    }

    @Test
    public void generatePositionNullPositionTest() {
        Assert.assertNull(testPattern.generatePosition(null, 40));
    }

    @Test
    public void generatePositionNegativeAgeTest() {
        Assert.assertNull(testPattern.generatePosition("Pensioned", -2));
    }

    @Test
    public void generatePositionJuniorTest() {
        Assert.assertEquals(testPattern.generatePosition("junior", 1), "Junior Developer");
    }

    @Test
    public void generatePositionDeveloperTest() {
        Assert.assertEquals(testPattern.generatePosition("middle", 1), "Developer 1");
    }

    @Test
    public void generatePositionDeveloper2Test() {
        Assert.assertEquals(testPattern.generatePosition("middle", 4), "Developer 2");
    }

    @Test
    public void generatePositionSeniorTest() {
        Assert.assertEquals(testPattern.generatePosition("senior", 4), "Senior 1");
    }

    @Test
    public void generatePositionSenior2Test() {
        Assert.assertEquals(testPattern.generatePosition("senior", 7), "Senior 2");
    }


}
