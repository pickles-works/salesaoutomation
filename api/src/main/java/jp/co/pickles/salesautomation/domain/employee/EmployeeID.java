package jp.co.pickles.salesautomation.domain.employee;

import jp.co.pickles.salesautomation.domain.base.UUIDType;

import java.util.UUID;

public class EmployeeID extends UUIDType<EmployeeID> {
    public EmployeeID(String value) {
        super(value);
    }

    public EmployeeID(UUID value) {
        super(value);
    }

    public EmployeeID() {
    }

    @Override
    protected boolean isNullable() {
        return true;
    }

    @Override
    public boolean same(EmployeeID that) {
        return this.equals(that);
    }

    @Override
    public String asText() {
        return this.toString();
    }
}
