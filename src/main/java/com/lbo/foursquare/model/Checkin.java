package com.lbo.foursquare.model;

import java.io.Serializable;

/**
 * User: lbouin
 * Date: 18/08/12
 * Time: 12:28
 */
public class Checkin implements Serializable {

    public String id;
    public Venue venue;
    public CompactUser user;

}
/*
{
        "id": "4e6fe1404b90c00032eeac34",
        "createdAt": 1315955008,
        "type": "checkin",
        "timeZone": "America/New_York",
                "user": {
                    "id": "1",
                    "firstName": "Jimmy",
                    "lastName": "Foursquare",
                    "photo": "https://foursquare.com/img/blank_boy.png",
                    "gender": "male",
                    "homeCity": "New York, NY",
                    "relationship": "self"
                    },
                "venue": {
                    "id": "4ab7e57cf964a5205f7b20e3",
                    "name": "foursquare HQ",
                    "contact": {
                    "twitter": "foursquare"
                    },
               "location": {
                    "address": "East Village",
                    "lat": 40.72809214560253,
                    "lng": -73.99112284183502,
                    "city": "New York",
                    "state": "NY",
                    "postalCode": "10003",
                    "country": "USA"
                    },

               "categories": [
                    {
                    "id": "4bf58dd8d48988d125941735",
                    "name": "Tech Startup",
                    "pluralName": "Tech Startups",
                    "shortName": "Tech Startup",
                    "icon": "https://foursquare.com/img/categories/building/default.png",
                    "parents": [
                    "Professional & Other Places",
                    "Offices"
                    ],
                    "primary": true
                    }
                    ],
        "verified": true,
        "stats": {
        "checkinsCount": 7313,
        "usersCount": 565,
        "tipCount": 128
        },
        "url": "http://foursquare.com"
        }
        }
        */


/*
{"meta":{"code":200},"notifications":[{"type":"notificationTray","item":{"unreadCount":0}}],"response":{"reply":{"id":"5036e615e4b0307ba26ab2ff","createdAt":1345775125,"source":{"id":"TLBDBURP0KA01TIW5GHTLIDFUQVQ2X4MCQFD40RQB1K12ZHY","name":"The Winester Square","photo":"https:\/\/foursquare.com\/img\/blank_app.png","icon":"https:\/\/foursquare.com\/img\/blank_app_16.png","detailUrl":"https:\/\/foursquare.com\/device\/app\/TLBDBURP0KA01TIW5GHTLIDFUQVQ2X4MCQFD40RQB1K12ZHY","url":"http:\/\/thewinestersquare.appspot.com"},"text":"Here is your reply","url":"http:\/\/thewinestersquare.appspot.com\/add?user=%s335864"}}}
 */
