package jp.co.pickles.salesautomation.domain.customer;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class CustomerName extends StringType<CustomerName> {
    public CustomerName(String value) {
        super(value);
    }

    public CustomerName() {
    }

    @Override
    protected boolean isNullable() {
        return false;
    }

    @Override
    protected Pattern pattern() {
        return null;
    }
}
