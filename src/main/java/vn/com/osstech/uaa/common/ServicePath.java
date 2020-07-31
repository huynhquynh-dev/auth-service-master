package vn.com.osstech.uaa.common;

/**
 * @author Truong Duong on 24/02/2020
 */
public class ServicePath {

    // PUBLIC
    public static final String PUBLIC = "/api/public";

    // AUTH
    public static final String AUTH = "/api/v1/auth";
    public static final String AUTH_LOGIN = "/login";
    public static final String AUTH_LOGOUT = "/logout";
    public static final String AUTH_FORGOT_PASS = "/forgot-password";

    // ACCOUNT
    public static final String ACCOUNT = "/api/v1/accounts";
    public static final String ACCOUNT_PROFILE = "/api/accounts/{id}/";

    public static final String PERMISSION = "/permission/";
    public static final String PERMISSION_ID = "/permission/{id}/";
    public static final String ROLE = "/role/";
    public static final String ROLE_ID = "/role/{id}/";
    public static final String ROLE_PERMISSION = "/role/{id}/permission";
    public static final String USER = "/user/";
    public static final String USER_ID = "/user/{id}/";
    public static final String USER_ROLE = "/user/{id}/role/";

}