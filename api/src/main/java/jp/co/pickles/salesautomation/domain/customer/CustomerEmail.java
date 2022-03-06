package jp.co.pickles.salesautomation.domain.customer;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class CustomerEmail extends StringType<CustomerEmail> {
    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}$");

    public CustomerEmail(String value) {
        super(value);
    }

    public CustomerEmail() {
    }

    @Override
    protected Pattern pattern() {
        return PATTERN;
    }

    @Override
    protected boolean isNullable() {
        return false;
    }
}
