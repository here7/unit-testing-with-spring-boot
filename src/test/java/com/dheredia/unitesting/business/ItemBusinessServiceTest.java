package com.dheredia.unitesting.business;

import com.dheredia.unitesting.ItemBusinessService;
import com.dheredia.unitesting.data.ItemRepository;
import com.dheredia.unitesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)  //Initialize my Mocks and inject them
public class ItemBusinessServiceTest {

    // Way 1 ) SomeDataService dataServiceMock = mock(SomeDataService.class);
    // Way 2) with @Mock annotation

    @Mock   //creates a mock that it will be injected with @InjectMocks annotation
            private ItemRepository repository;

    @InjectMocks    //creates an instance of the class and injects the mocks have been created with @Mock
    private ItemBusinessService business;


    @Test
    public void calcularSumDataServiceTest(){
        when(repository.findAll()).thenReturn(
                Arrays.asList(
                        new Item(1,"Item 1",10,10),
                        new Item(2,"Item 2",20,20),
                        new Item(3,"Item 3",30,30)
                )
        ); //dataServiceMock.retrieveAllData will return  new int[] { 1,2,3 }

        List<Item> items = business.retrieveAllItems();

        assertEquals(100, items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());
        assertEquals(900, items.get(2).getValue());
    }
}
