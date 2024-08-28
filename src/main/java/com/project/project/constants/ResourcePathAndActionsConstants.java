package com.project.project.constants;

public class ResourcePathAndActionsConstants {

    // Origin request
    public static final String ORIGIN = "http://localhost:4200";

    // Google recaptcha url
    public static final String GOOGLE_RECAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify";
    
    // Methods
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final String OPTIONS = "OPTIONS";
    public static final String API_ALL = "/api/**";
    public static final String AUTH_ALL = "/auth/**";

    // API Resource Path
    public static final String ROLE_USER = "ROLE_USER";
    public static final String AUTH = "/auth";
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";
    public static final String VERIFY_OTP = "/verify-otp";
    public static final String FORGOT_PASSWORD = "/reset-verify-otp";
    public static final String RESET_PASSWORD = "/reset-new-password";
    public static final String UPDATE_PASSWORD = "/update-password";
    public static final String CATEGORY = "/api/category";
    public static final String CATEGORY_DRINK = "/api/category-drink";
    public static final String FLAVOR = "/api/flavor";
    public static final String ITEM = "/api/item";
    public static final String ITEM_OPTION = "/api/item-option";
    public static final String ITEM_TYPE = "/api/item-type";
    public static final String SIZE = "/api/size";
    public static final String ORDER = "/api/order";
    public static final String PAYMENT_METHOD = "/api/payment-method";
    public static final String ADDRESS = "/api/address";
    public static final String SHIPPING = "/api/shipping";
    public static final String USER = "/api/user";
    public static final String SCHEDULE_WEEKDAY = "/api/schedule-weekday";
    public static final String SCHEDULE_PERIOD = "/api/schedule-period";

    // API Action
    public static final String GET_BY_ID = "/{id}";
    public static final String CREATE = "/create";
    public static final String UPDATE_ID = "/update/{id}";
    public static final String DELETE_ID = "/delete/{id}";
    public static final String AUTH_LOGIN = "/auth/login";
    public static final String AUTH_REGISTER = "/auth/register";
    public static final String AUTH_RESET_VERIFY_OTP = "/auth/reset-verify-otp";
    public static final String AUTH_RESET_NEW_PASSWORD = "/auth/reset-new-password";
}
