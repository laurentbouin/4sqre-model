package com.lbo;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lbo.foursquare.Response;
import com.lbo.foursquare.response.SelfCompactResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

/**
 * @author lbouin
 */
public class SelfCompactResponseTest {

    private BufferedReader in = null;

    @Before
    public void setup()
            throws IOException
    {
        in = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/selfResponse-jimmy.json")));
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
        Type selfCompactResponseType = new TypeToken<Response<SelfCompactResponse>>() {}.getType();

        Response<SelfCompactResponse> result = new Gson().fromJson(reader,  selfCompactResponseType);

        assertTrue(result.isOK());

        assertEquals("firstName is incorrect",result.response.user.firstName,"Jimmy");
        assertEquals("lastName is incorrect",result.response.user.lastName,"F.");
        assertEquals("ID is incorrect",result.response.user.id,new Long(1));
        assertEquals("Gender is incorrect",result.response.user.gender,"male");
        assertEquals("HomeCity is incorrect",result.response.user.homeCity,"New York, NY");

    }

}
