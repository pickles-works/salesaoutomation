package jp.co.pickles.salesautomation.domain.auth.accesstoken;

import jp.co.pickles.salesautomation.domain.account.AccountID;

public interface AccessTokenFactory {
    AccessToken generate(AccountID accountId);
}
