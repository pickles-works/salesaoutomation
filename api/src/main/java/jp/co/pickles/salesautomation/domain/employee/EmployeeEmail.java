package jp.co.pickles.salesautomation.domain.employee;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class EmployeeEmail extends StringType<EmployeeEmail> {
    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}$");

    public EmployeeEmail(String value) {
        super(value);
    }

    public EmployeeEmail() {
    }

    @Override
    public boolean same(EmployeeEmail that) {
        return this.equals(that);
    }

    @Override
    protected Pattern pattern() {
        return PATTERN;
    }

    @Override
    public String asText() {
        return this.toString();
    }

    @Override
    protected boolean isNullable() {
        return false;
    }
}
