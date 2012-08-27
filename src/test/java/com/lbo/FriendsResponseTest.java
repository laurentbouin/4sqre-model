package com.lbo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.lbo.foursquare.Response;
import com.lbo.foursquare.response.FriendsResponse;
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
public class FriendsResponseTest {

    private BufferedReader in = null;

    @Before
    public void setup()
            throws IOException
    {
        in = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/friends.json")));
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
        Type friendsResponseType = new TypeToken<Response<FriendsResponse>>() {}.getType();

        Response<FriendsResponse> result = new Gson().fromJson(reader,  friendsResponseType);

        assertTrue(result.isOK());

        assertEquals("Number of friends is incorrect",result.response.friends.count,2);

        assertEquals("Firstname is incorrect","Laurent",result.response.friends.items.get(0).firstName);

        assertEquals("Firstname is incorrect","Jimmy",result.response.friends.items.get(1).firstName);

        /*assertEquals("lastName is incorrect",result.response.user.lastName,"F.");
        assertEquals("ID is incorrect",result.response.user.id,new Long(1));
        assertEquals("Gender is incorrect",result.response.user.gender,"male");
        assertEquals("HomeCity is incorrect",result.response.user.homeCity,"New York, NY");
        */

    }

}
