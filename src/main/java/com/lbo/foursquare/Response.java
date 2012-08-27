package com.lbo.foursquare;

import com.lbo.foursquare.response.Meta;

/**
 * @author lbouin
 */
public class Response <T> {

    public Meta meta;
    public T response;

    public boolean isOK(){
        return meta.code == 200;
    }

}
