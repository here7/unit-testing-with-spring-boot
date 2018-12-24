package com.dheredia.unitesting;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SomeBusinessTest {

    @Test
    public void calculateSumBasicTest(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int current_result = business.calculareSum(new int[] {1,2,3});
        int expected_result = 6;

        assertEquals(expected_result, current_result);
    }

    @Test
    public void calculateSumEmptyTest(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int current_result = business.calculareSum(new int[] { });
        int expected_result = 0;

        assertEquals(expected_result, current_result);
    }

}
