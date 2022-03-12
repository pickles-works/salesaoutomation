package jp.co.pickles.salesautomation.domain.account;

public class Account {
    private final AccountID accountID;
    private final LoginID loginID;
    private final Locked locked;
    private final Role role;
    private final AccountEmail email;

    public Account(AccountID accountID, LoginID loginID, Locked locked, Role role, AccountEmail email) {
        this.accountID = accountID;
        this.loginID = loginID;
        this.locked = locked;
        this.role = role;
        this.email = email;
    }

    public Account() {
        this.accountID = new AccountID();
        this.loginID = new LoginID();
        this.locked = new Locked();
        this.role = new Role();
        this.email = new AccountEmail();
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

    public AccountEmail getEmail() {
        return this.email;
    }
}
