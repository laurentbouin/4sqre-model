package com.lbo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.lbo.foursquare.Response;
import com.lbo.foursquare.model.Checkin;
import com.lbo.foursquare.response.EmptyResponse;
import com.lbo.foursquare.response.FriendsResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author lbouin
 */
public class BasicResponseTest {

    private BufferedReader in = null;

    @Before
    public void setup()
            throws IOException
    {
        in = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/justMetaResponse.json")));
    }

    @After
    public void teardown()
            throws IOException
    {
        if (in != null)
        {
            in.close();
        }
        in = null;

    }

    @Test
    public void basic(){

        JsonReader reader = new JsonReader(in);
        Type basicResponseType = new TypeToken<Response<EmptyResponse>>() {}.getType();

        Response<EmptyResponse> onlyMeta = new Gson().fromJson(reader, basicResponseType);

        assertFalse(onlyMeta.isOK());
        assertEquals(400, onlyMeta.meta.code);
        assertEquals("param_error",onlyMeta.meta.errorType);
        assertEquals("Invalid checkin id",onlyMeta.meta.errorDetail);

    }

}
