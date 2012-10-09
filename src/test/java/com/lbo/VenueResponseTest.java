package com.lbo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.lbo.foursquare.Response;
import com.lbo.foursquare.response.EmptyResponse;
import com.lbo.foursquare.response.VenueResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author lbouin
 */
public class VenueResponseTest {

    private BufferedReader in = null;

    @Before
    public void setup()
            throws IOException
    {
        in = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/venue.json")));
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
        Type basicResponseType = new TypeToken<Response<VenueResponse>>() {}.getType();

        Response<VenueResponse> venueResponse = new Gson().fromJson(reader, basicResponseType);

        assertTrue(venueResponse.isOK());
        assertEquals("40.721294", venueResponse.response.venue.location.lat);
        assertEquals("-73.983994", venueResponse.response.venue.location.lng);


    }

}
