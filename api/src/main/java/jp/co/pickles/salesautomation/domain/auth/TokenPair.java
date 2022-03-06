package jp.co.pickles.salesautomation.domain.auth;

import jp.co.pickles.salesautomation.domain.auth.accesstoken.AccessToken;
import jp.co.pickles.salesautomation.domain.auth.refreshtoken.RefreshToken;

public class TokenPair {
    private AccessToken accessToken;
    private RefreshToken refreshToken;

    public TokenPair(AccessToken accessToken, RefreshToken refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public RefreshToken getRefreshToken() {
        return refreshToken;
    }
}
