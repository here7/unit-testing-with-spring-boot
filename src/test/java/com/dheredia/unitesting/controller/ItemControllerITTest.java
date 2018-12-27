package com.dheredia.unitesting.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerITTest {

    @Autowired
    private TestRestTemplate restTemplate;


    /**
     * Integration Tests
     */
    @Test
    public void contextLoads(){
        String response = this.restTemplate.getForObject("/all-items-from-db", String.class);
        try {
            JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]",
                    response,
                    false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
