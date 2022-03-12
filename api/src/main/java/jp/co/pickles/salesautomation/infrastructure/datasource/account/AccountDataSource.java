package jp.co.pickles.salesautomation.infrastructure.datasource.account;

import jp.co.pickles.salesautomation.domain.account.AccountID;
import jp.co.pickles.salesautomation.domain.account.AccountRepository;
import jp.co.pickles.salesautomation.domain.account.AccountWithPassword;
import jp.co.pickles.salesautomation.domain.account.LoginID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDataSource implements AccountRepository {

    @Autowired
    AccountMapper mapper;

    @Override
    public AccountWithPassword findWithPasswordBy(LoginID loginID) {
        return null;
    }

    @Override
    public AccountWithPassword getWithPassword(AccountID accountID) {
        return null;
    }
}
