package jp.co.pickles.salesautomation.domain.account;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class AccountEmail extends StringType<AccountEmail> {
    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}$");

    public AccountEmail(String value) {
        super(value);
    }

    public AccountEmail() {
    }

    @Override
    public boolean same(AccountEmail that) {
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
