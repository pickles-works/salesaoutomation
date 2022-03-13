package jp.co.pickles.salesautomation.domain.employee;

import jp.co.pickles.salesautomation.domain.account.AccountID;

public class Employee {
    private EmployeeID id;
    private EmployeeName name;
    private EmployeeEmail email;
    private AccountID accountID;

    public Employee(EmployeeID id, EmployeeName name, EmployeeEmail email, AccountID accountID) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accountID = accountID;
    }

    public Employee() {
        this.id = new EmployeeID();
        this.name = new EmployeeName();
        this.email = new EmployeeEmail();
        this.accountID = new AccountID();
    }
}
