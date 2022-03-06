package jp.co.pickles.salesautomation.domain.account.password;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class PlainTextPassword extends StringType<PlainTextPassword> {
    public PlainTextPassword(String value) {
        super(value);
    }

    public PlainTextPassword() {
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
