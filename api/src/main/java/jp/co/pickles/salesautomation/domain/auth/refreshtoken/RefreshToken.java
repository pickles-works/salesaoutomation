package jp.co.pickles.salesautomation.domain.auth.refreshtoken;

import jp.co.pickles.salesautomation.domain.base.UUIDType;

import java.util.UUID;

public class RefreshToken extends UUIDType<RefreshToken> {
    public RefreshToken(String value) {
        super(value);
    }

    public RefreshToken(UUID value) {
        super(value);
    }

    public RefreshToken() {
    }

    @Override
    protected boolean isNullable() {
        return false;
    }
}
