package com.dheredia.unitesting;

import com.dheredia.unitesting.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {

    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);


    @Before
    public void before(){
        business.setDataService( dataServiceMock );     //implements from interface
    }

    /**
     * Test with MOCK
     */
    @Test
    public void calcularSumDataServiceTest(){

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1,2,3 }); //dataServiceMock.retrieveAllData will return  new int[] { 1,2,3 } from

        assertEquals(6, business.calcularSumDataService());
    }


    @Test
    public void calcularSumDataServiceEmptyTest(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { }); //dataServiceMock.retrieveAllData will return  new int[] {  } from

        assertEquals(0, business.calcularSumDataService());
    }
}
