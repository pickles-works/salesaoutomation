package jp.co.pickles.salesautomation.domain.auth.accesstoken;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class AccessToken extends StringType<AccessToken> {
    private static final String TOKEN_PREFIX = "Bearer ";

    public AccessToken(String value) {
        super(TOKEN_PREFIX + value);
    }

    public AccessToken() {
    }

    public String getJwtValue() {
        return this.value.substring(TOKEN_PREFIX.length());
    }

    @Override
    protected Pattern pattern() {
        return Pattern.compile("^Bearer [A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$");
    }

    @Override
    protected boolean isNullable() {
        return false;
    }
}
