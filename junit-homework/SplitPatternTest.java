package com.endava.junit.process.test;

import com.endava.junit.process.ProcessPattern;
import com.endava.junit.process.SplitPattern;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tvasile on 7/21/2016.
 */
public class SplitPatternTest {


    SplitPattern testPattern;

    @Before
    public void setUp() {
        testPattern = new SplitPattern();
    }

    @Test
    public void getStringLengthNullTest() {
        Assert.assertNull(testPattern.getStringLength(null));
    }

    @Test
    public void getStringLengthSmallTest() {
        Assert.assertEquals(testPattern.getStringLength("John"), "small");
    }

    @Test
    public void getStringLengthMediumTest() {
        Assert.assertEquals(testPattern.getStringLength("JeanPierre"), "medium");
    }

    @Test
    public void getStringLengthLongTest() {
        Assert.assertEquals(testPattern.getStringLength("FredericoAugustoDeLaManchu"), "long");
    }

    @Test
    public void splitByLengthTest() {
        List<String> testList = new ArrayList<String>();
        testList.add("John");
        testList.add("JeanPierre");
        testList.add("FredericoAugustoDeLaManchu");
        List<String> resultList = new ArrayList<String>();
        resultList.add("small");
        resultList.add("medium");
        resultList.add("long");
        Assert.assertEquals(testPattern.splitByLength(testList), resultList);
    }
}
