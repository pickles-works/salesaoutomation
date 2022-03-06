package jp.co.pickles.salesautomation.domain.user;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class UserName extends StringType<UserName> {
    public UserName(String value) {
        super(value);
    }

    public UserName() {
    }

    @Override
    public boolean same(UserName that) {
        return this.equals(that);
    }

    @Override
    protected Pattern pattern() {
        return null;
    }

    @Override
    protected boolean isNullable() {
        return false;
    }
}
