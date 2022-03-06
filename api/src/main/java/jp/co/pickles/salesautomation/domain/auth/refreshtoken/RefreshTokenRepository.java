package jp.co.pickles.salesautomation.domain.auth.refreshtoken;

import jp.co.pickles.salesautomation.domain.account.Account;

public interface RefreshTokenRepository {
    RefreshToken generate(Account account);
    boolean nonExpired(RefreshToken refreshToken);
}
