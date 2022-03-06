package jp.co.pickles.salesautomation.domain.user;

import jp.co.pickles.salesautomation.domain.base.UUIDType;

import java.util.UUID;

public class UserID extends UUIDType<UserID> {
    public UserID(String value) {
        super(value);
    }

    public UserID(UUID value) {
        super(value);
    }

    public UserID() {
    }

    @Override
    protected boolean isNullable() {
        return true;
    }

    @Override
    public boolean same(UserID that) {
        return this.equals(that);
    }

    @Override
    public String asText() {
        return this.toString();
    }
}
