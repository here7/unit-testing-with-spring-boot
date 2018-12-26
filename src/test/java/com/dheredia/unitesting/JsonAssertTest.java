package com.dheredia.unitesting;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actual = "{\"quantity\":100,\"id\":1,\"name\":\"Ball\",\"price\":10}";

    /**
     * true parameter in assertEquals indicates an extrict comparison
     * @throws JSONException
     */
    @Test
    public void jsonAssertTrueTest() throws JSONException {
        String expected = "{\"quantity\":100,\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expected, actual, true);
    }

    @Test
    public void jsonAssertFalseTest() throws JSONException {
        String expected = "{\"quantity\":100,\"id\":1}";
        JSONAssert.assertEquals(expected, actual, false);
    }
}
