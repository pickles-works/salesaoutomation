package jp.co.pickles.salesautomation.domain.user;

import jp.co.pickles.salesautomation.domain.account.AccountID;

public class User {
    private UserID id;
    private UserName name;
    private UserEmail email;
    private AccountID accountID;

    public User(UserID id, UserName name, UserEmail email, AccountID accountID) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accountID = accountID;
    }

    public User() {
        this.id = new UserID();
        this.name = new UserName();
        this.email = new UserEmail();
        this.accountID = new AccountID();
    }
}
