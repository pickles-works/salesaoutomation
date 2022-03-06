package jp.co.pickles.salesautomation.domain.customer;

public class Customer {
    private final CustomerID id;
    private final CustomerEmail email;
    private final CustomerRegisterStatus registerStatus;
    private final CustomerName name;
    private final CustomerGender genderType;
    private final CustomerBirthDay birthDay;

    private Customer(
            CustomerID id,
            CustomerEmail email,
            CustomerRegisterStatus registerStatus,
            CustomerName name,
            CustomerGender genderType,
            CustomerBirthDay birthDay) {
        this.id = id;
        this.email = email;
        this.registerStatus = registerStatus;
        this.name = name;
        this.genderType = genderType;
        this.birthDay = birthDay;
    }

    // MyBatis や Jackson などから呼び出されるデフォルトコンストラクタ
    public Customer() {
        this.id = new CustomerID();
        this.email = new CustomerEmail();
        this.registerStatus = new CustomerRegisterStatus();
        this.name = new CustomerName();
        this.genderType = new CustomerGender();
        this.birthDay = new CustomerBirthDay();
    }

    public static Customer create(
            CustomerEmail email,
            CustomerRegisterStatus registerStatus,
            CustomerName name,
            CustomerGender genderType,
            CustomerBirthDay birthDay) {
        return new Customer(
                CustomerID.create(),
                email,
                registerStatus,
                name,
                genderType,
                birthDay
        );
    }

    public static Customer empty() {
        return new Customer();
    }
}
