package jp.co.pickles.salesautomation.auth;

import jp.co.pickles.salesautomation.SalesAutomationApplication;

public class Constants {
    static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;
    static final String HEADER_STRING = "Authorization";
    static final String TOKEN_PREFIX = "Bearer ";
    static final String SIGN_UP_URL = "/signup";
    static final String LOGIN_URL = "/login";
}
