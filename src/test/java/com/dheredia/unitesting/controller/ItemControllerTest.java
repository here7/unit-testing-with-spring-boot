package com.dheredia.unitesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void itemTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);

        try{
            MvcResult result = mockMvc.perform(request).andReturn();
            assertEquals("{\"quantity\":100,\"id\":1,\"name\":\"Ball\",\"price\":10}",result.getResponse().getContentAsString());
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
}
