package jp.co.pickles.salesautomation.domain.account;

import jp.co.pickles.salesautomation.domain.base.UUIDType;

import java.util.UUID;

public class AccountID extends UUIDType<AccountID> {
    public AccountID(String value) {
        super(value);
    }

    public AccountID(UUID value) {
        super(value);
    }

    public AccountID() {
    }

    @Override
    protected boolean isNullable() {
        return true;
    }
}
