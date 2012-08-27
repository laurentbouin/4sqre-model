4sqre-model
=============

A simple POJO collection to simply parse Foursquare responses with [GSON](http://code.google.com/p/google-gson/)
    

How To
----------------------------------------------

   * Import the [GSON](http://code.google.com/p/google-gson/) library
   * request the [Foursquare API](https://developer.foursquare.com/overview/)
   * transform the response
   
Examples   
--------

##### Friends response

String foursquareResult = //your call to Foursquare Friends endpoint
Type friendsResponseType = new TypeToken<Response<FriendsResponse>>() {}.getType();
Response<FriendsResponse> result = new Gson().fromJson(foursquareResult,  friendsResponseType);

//result.response.friends.count ==> the number of friends
//result.response.friends.items ==> the friends's list

#### Checkin

If, like me, you're developping a connected app, you have handle checkins, that's simpler:

Checkin pushed = new Gson().fromJson(checkinAsString, Checkin.class); 


Author
-------

**Laurent Bouin**

+ http://twitter.com/laurentbouin
+ http://about.me/laurentbouin