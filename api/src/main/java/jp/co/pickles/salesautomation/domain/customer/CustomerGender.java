package jp.co.pickles.salesautomation.domain.customer;

import jp.co.pickles.salesautomation.domain.base.EnumType;

public class CustomerGender extends EnumType<CustomerGender, CustomerGender.Type> {
    public CustomerGender(String value) {
        super(Type.valueOf(value));
    }

    public CustomerGender(Type value) {
        super(value);
    }

    public CustomerGender() {
        super(Type.UNKNOWN);
    }

    @Override
    protected boolean isNullable() {
        return false;
    }

    public enum Type {
        MALE, FEMALE, UNKNOWN
    }
}
