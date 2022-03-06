package jp.co.pickles.salesautomation.domain.customer;

import jp.co.pickles.salesautomation.domain.base.UUIDType;

import java.util.UUID;

public class CustomerID extends UUIDType<CustomerID> {
    public CustomerID(String value) {
        super(value);
    }

    public CustomerID(UUID value) {
        super(value);
    }

    public CustomerID() {
    }

    @Override
    protected boolean isNullable() {
        return true;
    }

    public static CustomerID create() {
        return new CustomerID(UUIDType.generate());
    }
}
