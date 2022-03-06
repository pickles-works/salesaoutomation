package jp.co.pickles.salesautomation.domain.base;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class DateType<T extends DateType<T>> extends PrimitiveType<LocalDate> implements ComparableValueObject<T> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public DateType(String value) {
        super(LocalDate.parse(value));
    }

    public DateType(LocalDate value) {
        super(value);
    }

    public DateType() {
    }

    @Override
    public String asText() {
        return this.value == null
                ? ""
                : formatter.format(this.value);
    }

    @Override
    public boolean largerThan(T that) {
        return this.value.isAfter(that.value);
    }

    @Override
    public boolean smallerThan(T that) {
        return this.value.isBefore(that.value);
    }

    @Override
    public boolean largerEquals(T that) {
        return this.largerThan(that) || this.same(that);
    }

    @Override
    public boolean smallerEquals(T that) {
        return this.smallerThan(that) || this.same(that);
    }

    @Override
    public boolean same(T that) {
        return this.value.isEqual(that.value);
    }

    @Override
    public boolean isValid() {
        if (this.value == null) return this.isNullable();
        return true;
    }
}
