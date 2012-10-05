package com.lbo.foursquare.response;

import com.lbo.foursquare.model.ExtendedCategory;

import java.io.Serializable;
import java.util.List;

/**
 * User: lbouin
 * Date: 24/09/12
 * Time: 21:35
 */
public class CategoriesResponse implements Serializable {

    public List<ExtendedCategory> categories;
}
