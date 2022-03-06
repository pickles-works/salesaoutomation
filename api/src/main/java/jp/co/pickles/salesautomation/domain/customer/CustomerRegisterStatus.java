package jp.co.pickles.salesautomation.domain.customer;

import jp.co.pickles.salesautomation.domain.base.EnumType;

public class CustomerRegisterStatus extends EnumType<CustomerRegisterStatus, CustomerRegisterStatus.Type> {
    public CustomerRegisterStatus(String value) {
        super(Type.valueOf(value));
    }

    public CustomerRegisterStatus(Type value) {
        super(value);
    }

    public CustomerRegisterStatus() {
    }

    @Override
    protected boolean isNullable() {
        return false;
    }

    public enum Type {
        REGISTERED, ANONYMOUS
    }
}
