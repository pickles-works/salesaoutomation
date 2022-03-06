package jp.co.pickles.salesautomation.domain.base;

import java.math.BigDecimal;

public abstract class BigDecimalType<T extends BigDecimalType<T>> extends PrimitiveType<BigDecimal> implements ComparableValueObject<T> {
    public BigDecimalType(BigDecimal value) {
        super(value);
    }

    public BigDecimalType() {
    }

    @Override
    public String asText() {
        return this.toString();
    }

    @Override
    public boolean largerThan(T that) {
        return this.value.compareTo(that.value) > 0;
    }

    @Override
    public boolean smallerThan(T that) {
        return this.value.compareTo(that.value) < 0;
    }

    @Override
    public boolean largerEquals(T that) {
        return this.value.compareTo(that.value) >= 0;
    }

    @Override
    public boolean smallerEquals(T that) {
        return this.value.compareTo(that.value) <= 0;
    }

    @Override
    public boolean same(T that) {
        return this.value.compareTo(that.value) == 0;
    }

    protected abstract BigDecimal maxLimit();
    protected abstract BigDecimal minLimit();

    @Override
    public boolean isValid() {
        if (this.value == null) return this.isNullable();
        return this.value.compareTo(this.maxLimit()) <= 0 && this.value.compareTo(this.minLimit()) >= 0;
    }
}
