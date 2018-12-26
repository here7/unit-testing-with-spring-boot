package com.dheredia.unitesting;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    List mock = mock(List.class);

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
}
