package com.dheredia.unitesting;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void listSizeTest(){
        when(mock.size()).thenReturn(6);
        assertEquals(6, mock.size());
    }

    @Test
    public void listDiffValuesTest(){
        when(mock.size()).thenReturn(6).thenReturn(4);
        assertEquals(6, mock.size());
        assertEquals(4, mock.size());
    }

    @Test
    public void listWithParametersTest(){
        when(mock.get(0)).thenReturn("hello");
        assertEquals("hello", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    /**
     * It always will return "hello" String
     */
    @Test
    public void listWithGenericParametersTest(){
        when(mock.get(anyInt())).thenReturn("hello");
        assertEquals("hello", mock.get(45));
        assertEquals("hello", mock.get(21));
    }

    @Test
    public void listVerificationTest(){
        String val = mock.get(0);
        String val2 = mock.get(1);

        verify(mock).get(0); //needs some any interaction with get(0). For this, we are defining the previous value
        //verify(mock).get(1); => FAIL

        verify(mock, atLeast(1)).get(anyInt());     //min invocations
        verify(mock, atLeastOnce()).get(anyInt());     //ever invocation

        verify(mock, atMost(20)).get(anyInt());    //max invocations
        verify(mock, times(2)).get(anyInt());    //exactly n invocations

        verify(mock, never()).get(15);  //it never is called
    }

    @Test
    public void listArgumentCapturingTest(){
        //SUT
        mock.add("DANI HEREDIA");

        //My verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("DANI HEREDIA", captor.getValue());
    }

    @Test
    public void listMultipleArgumentCapturingTest(){
        //SUT
        mock.add("DANI");
        mock.add("HEREDIA");

        //My verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("DANI", allValues.get(0));
        assertEquals("HEREDIA", allValues.get(1));
    }


    @Test
    public void listPreviousSpyTest(){
        ArrayList aListMock = mock(ArrayList.class);
        System.out.println(aListMock.get(0));   //null
        System.out.println(aListMock.size());   //0

        aListMock.add("DANI");
        aListMock.add("DANI HEREDIA");
        System.out.println(aListMock.size());   //0

        when(aListMock.size()).thenReturn(5);

        System.out.println(aListMock.size());   //5

        assertEquals(5, aListMock.size());
    }

    /**
     * SPY by default, retains the original class behaviour (code)
     */
    @Test
    public void listSpyTest(){
        ArrayList aListSpy = spy(ArrayList.class);

        aListSpy.add("Initialized");

        System.out.println(aListSpy.get(0));   //Initialized
        System.out.println(aListSpy.size());   //1

        aListSpy.add("DANI");
        aListSpy.add("DANI HEREDIA");
        System.out.println(aListSpy.size());   //3

        when(aListSpy.size()).thenReturn(5);
        System.out.println(aListSpy.size());   //5

        aListSpy.add("DANI H M");
        System.out.println(aListSpy.size());   //5

        assertEquals(5, aListSpy.size());
    }
}
