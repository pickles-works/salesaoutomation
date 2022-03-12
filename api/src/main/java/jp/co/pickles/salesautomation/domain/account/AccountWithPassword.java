package jp.co.pickles.salesautomation.domain.account;

import jp.co.pickles.salesautomation.domain.account.password.HashingPassword;
import jp.co.pickles.salesautomation.domain.account.password.PlainTextPassword;

public class AccountWithPassword extends Account {
    private final HashingPassword password;

    public AccountWithPassword(AccountID accountID, LoginID loginID, Locked locked, Role role, AccountEmail email, HashingPassword password) {
        super(accountID, loginID, locked, role, email);
        this.password = password;
    }

    public AccountWithPassword() {
        super();
        this.password = new HashingPassword();
    }

    public boolean matchPassword(PlainTextPassword plainTextPassword) {
        return password.matches(plainTextPassword);
    }

    public Account withoutPassword() {
        return new Account(
                this.getAccountID(),
                this.getLoginID(),
                this.getLocked(),
                this.getRole(),
                this.getEmail()
        );
    }
}
