package jp.co.pickles.salesautomation.domain.customer;

import jp.co.pickles.salesautomation.domain.base.DateType;

import java.time.LocalDate;

public class CustomerBirthDay extends DateType<CustomerBirthDay> {
    public CustomerBirthDay(LocalDate value) {
        super(value);
    }

    public CustomerBirthDay() {
    }

    @Override
    protected boolean isNullable() {
        return true;
    }
}
