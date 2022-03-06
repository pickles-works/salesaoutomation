package jp.co.pickles.salesautomation.domain.account;

public interface AccountRepository {
    AccountWithPassword findWithPasswordBy(LoginID loginID);
    AccountWithPassword getWithPassword(AccountID accountID);
}
