package com.dheredia.unitesting;

import com.dheredia.unitesting.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)  //Initialize my Mocks and inject them
public class SomeBusinessMockTest {

    // Way 1 ) SomeDataService dataServiceMock = mock(SomeDataService.class);
    // Way 2) with @Mock annotation

    @Mock   //creates a mock that it will be injected with @InjectMocks annotation
    SomeDataService dataServiceMock;

    @InjectMocks    //creates an instance of the class and injects the mocks have been created with @Mock
    SomeBusinessImpl business = new SomeBusinessImpl();

    @Before
    public void before(){
        business.setDataService( dataServiceMock );     //implements from interface
    }

    @Test
    public void calcularSumDataServiceTest(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1,2,3 }); //dataServiceMock.retrieveAllData will return  new int[] { 1,2,3 }

        assertEquals(6, business.calcularSumDataService());
    }

    @Test
    public void calcularSumDataServiceEmptyTest(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { }); //dataServiceMock.retrieveAllData will return  new int[] {  }

        assertEquals(0, business.calcularSumDataService());
    }
}
