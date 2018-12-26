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
@WebMvcTest(HiThereController.class)
public class HiThereControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hiThereTest() throws Exception {
        //We are calling at /hi-there URL
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hi-there")
                .accept(MediaType.APPLICATION_JSON);

        try{
            MvcResult result = mockMvc.perform(request).andReturn();
            assertEquals("Hi there",result.getResponse().getContentAsString());
        } catch(Exception e){
            throw new Exception(e);
        }
    }

    @Test
    public void hiThereCheckingStatusTest() throws Exception {
        //We are calling at /hi-there URL
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hi-there")
                .accept(MediaType.APPLICATION_JSON);

        try{
            MvcResult result = mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().string("Hi there"))
                    .andReturn();
        } catch(Exception e){
            throw new Exception(e);
        }
    }
}
