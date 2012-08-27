package com.lbo.foursquare.model;

import java.io.Serializable;
import java.util.List;

/**
 * User: lbouin
 * Date: 26/08/12
 * Time: 14:22
 */
public class FriendsList implements Serializable {

    public int count;
    public List <CompactUser> items;
}
