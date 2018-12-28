package com.dheredia.unitesting.controller;

import com.dheredia.unitesting.ItemBusinessService;
import com.dheredia.unitesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void itemTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);

        try{
            MvcResult result = mockMvc.perform(request).andReturn();
            assertEquals("{\"id\":1,\"quantity\":100,\"name\":\"Ball\",\"price\":10,\"value\":0}",result.getResponse().getContentAsString());
        } catch(Exception e){
            throw new Exception(e);
        }
    }

    @Test
    public void itemCheckingStatusTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);
        try{
            MvcResult result = mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().json("{\"quantity\":100,\"id\":1,\"name\":\"Ball\",\"price\":10}"))
                    .andReturn();
        } catch(Exception e){
            throw new Exception(e);
        }
    }

    @Test
    public void itemFromBusinessServiceTest() throws Exception {

        /* The Bean Mocks are NULL by default. So, I give it the below value... */
        when(businessService.retreiveHardcodedItem()).thenReturn(
                new Item(2,"Item 2",10,10)
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        try{
            MvcResult result = mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().json("{\"quantity\":10,\"id\":2,\"name\":\"Item 2\",\"price\":10}"))
//                    .andExpect(content().json("{\"id:2,name:Item2, price:10,quantity:10}"))
                    .andReturn();
        } catch(Exception e){
            throw new Exception(e);
        }
    }

    /**
     * All items from DB
     * @throws Exception
     */
    @Test
    public void retrieveAllItemsTest() throws Exception {

        /* The Bean Mocks are NULL by default. So, I give it the below value... */
        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(
                        new Item(1,"Item 1",10,10),
                        new Item(2,"Item 2",20,20),
                        new Item(3,"Item 3",30,30)
                )
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-db")
                .accept(MediaType.APPLICATION_JSON);

        try{
            MvcResult result = mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().json("[{\"quantity\":10,\"id\":1,\"name\":\"Item 1\",\"price\":10},{\"quantity\":20,\"id\":2,\"name\":\"Item 2\",\"price\":20}, {\"quantity\":30,\"id\":3,\"name\":\"Item 3\",\"price\":30}]"))
                    .andReturn();
        } catch(Exception e){
            throw new Exception(e);
        }
    }
}
