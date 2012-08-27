package com.lbo.foursquare.response;

import com.lbo.foursquare.model.CompactUser;
import com.lbo.foursquare.model.FriendsList;

import java.io.Serializable;

/**
 * @author lbouin
 */
public class FriendsResponse implements Serializable{

    public FriendsList friends;
}
