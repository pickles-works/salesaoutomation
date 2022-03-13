package jp.co.pickles.salesautomation.domain.employee;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class EmployeeName extends StringType<EmployeeName> {
    public EmployeeName(String value) {
        super(value);
    }

    public EmployeeName() {
    }

    @Override
    public boolean same(EmployeeName that) {
        return this.equals(that);
    }

    @Override
    protected Pattern pattern() {
        return null;
    }

    @Override
    protected boolean isNullable() {
        return false;
    }
}
