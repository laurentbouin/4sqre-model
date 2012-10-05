package com.lbo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.lbo.foursquare.Response;
import com.lbo.foursquare.model.ExtendedCategory;
import com.lbo.foursquare.response.CategoriesResponse;
import com.lbo.foursquare.response.FriendsResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author lbouin
 */
public class CategoriesResponseTest {

    private BufferedReader in = null;

    @Before
    public void setup()
            throws IOException
    {
        in = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/categories.json")));
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
        Type friendsResponseType = new TypeToken<Response<CategoriesResponse>>() {}.getType();

        Response<CategoriesResponse> result = new Gson().fromJson(reader,  friendsResponseType);

        assertTrue(result.isOK());
        assertEquals(9,result.response.categories.size());

        List<ExtendedCategory> categories = new ArrayList<ExtendedCategory>();
        categories.addAll(result.response.categories);

        for(ExtendedCategory cat : result.response.categories){
            System.out.println("Categorie: "+cat.name+": "+cat.icon.prefix+cat.icon.suffix);

            if(cat.categories != null && !cat.categories.isEmpty()){
                categories.addAll(cat.categories);
                for(ExtendedCategory subcat : cat.categories){
                    if(subcat.categories != null && !subcat.categories.isEmpty()){
                        categories.addAll(subcat.categories);

                        for(ExtendedCategory subsubcat : subcat.categories){
                            if(subsubcat.categories != null && !subsubcat.categories.isEmpty()){
                                categories.addAll(subcat.categories);

                            }

                        }


                    }

                }

            }

        }

        System.out.println("Nb cat: "+categories.size());

        for (ExtendedCategory finalCat : categories){
         //   System.out.println("Categorie: "+finalCat.name+": "+finalCat.icon.prefix+finalCat.icon.suffix);
        }
        //assertEquals("Number of friends is incorrect",result.response.friends.count,2);
        //assertEquals("Firstname is incorrect","Laurent",result.response.friends.items.get(0).firstName);
        //assertEquals("Firstname is incorrect","Jimmy",result.response.friends.items.get(1).firstName);


    }

}
