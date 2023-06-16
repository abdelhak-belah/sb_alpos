package com.amenass.sb_alpos.keys;


public class EndpointKey {
    // Base
    public static final String ENDPOINT_HOST = "http://localhost:1997";
    public static final String ENDPOINT_API = "/api/";

    // Auth
    public static final String ENDPOINT_AUTH = ENDPOINT_API+"auth";
    public static final String ENDPOINT_REGISTER = ENDPOINT_AUTH+"/register";
    public static final String ENDPOINT_LOGIN = ENDPOINT_AUTH+"/login";
    public static final String ENDPOINT_LOGOUT = ENDPOINT_AUTH+"/logout";
    public static final String ENDPOINT_REFRESH_TOKEN = ENDPOINT_AUTH+"/refresh-token";

    // User
    public static final String ENDPOINT_USER = ENDPOINT_API+"users";

    // Role
    public static final String ENDPOINT_ROLE = ENDPOINT_API+"roles";

    // Discover
    public static final String ENDPOINT_DISCOVER = ENDPOINT_API + "discovers";
}
