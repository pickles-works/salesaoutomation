package jp.co.pickles.salesautomation.domain.account;

public class Account {
    private AccountID accountID;
    private LoginID loginID;
    private Locked locked;
    private Role role;

    public Account(AccountID accountID, LoginID loginID, Locked locked, Role role) {
        this.accountID = accountID;
        this.loginID = loginID;
        this.locked = locked;
        this.role = role;
    }

    public Account() {
        this.accountID = new AccountID();
        this.loginID = new LoginID();
        this.locked = new Locked();
        this.role = new Role();
    }

    public AccountID getAccountID() {
        return accountID;
    }

    public LoginID getLoginID() {
        return loginID;
    }

    public boolean isLocked() {
        return this.locked.isLocked();
    }

    protected Locked getLocked() {
        return locked;
    }

    public Role getRole() {
        return role;
    }

    public boolean hasRole() {
        return !this.role.isEmpty();
    }
}
