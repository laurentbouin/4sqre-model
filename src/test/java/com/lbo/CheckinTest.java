package com.lbo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.lbo.foursquare.Response;
import com.lbo.foursquare.model.Checkin;
import com.lbo.foursquare.response.SelfCompactResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author lbouin
 */
public class CheckinTest {

    private BufferedReader in = null;

    @Before
    public void setup()
            throws IOException
    {
        in = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/checkin.json")));
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

        Checkin checkin = new Gson().fromJson(reader,  Checkin.class);

        assertEquals(new Long(1),checkin.user.id);
        assertEquals("4ab7e57cf964a5205f7b20e3",checkin.venue.id);

    }

}
