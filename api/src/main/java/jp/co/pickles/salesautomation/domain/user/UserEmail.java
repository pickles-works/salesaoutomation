package jp.co.pickles.salesautomation.domain.user;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class UserEmail extends StringType<UserEmail> {
    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}$");

    public UserEmail(String value) {
        super(value);
    }

    public UserEmail() {
    }

    @Override
    public boolean same(UserEmail that) {
        return this.equals(that);
    }

    @Override
    protected Pattern pattern() {
        return PATTERN;
    }

    @Override
    public String asText() {
        return this.toString();
    }

    @Override
    protected boolean isNullable() {
        return false;
    }
}
