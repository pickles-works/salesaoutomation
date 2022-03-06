package jp.co.pickles.salesautomation.domain.account;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class LoginID extends StringType<LoginID> {
    public LoginID(String value) {
        super(value);
    }

    public LoginID() {
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
