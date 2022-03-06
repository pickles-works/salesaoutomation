package jp.co.pickles.salesautomation.domain.base;

public abstract class LongType<T extends LongType<T>> extends PrimitiveType<Long> implements ComparableValueObject<T> {
    public LongType(Long value) {
        super(value);
    }

    public LongType() {
    }

    @Override
    public String asText() {
        return this.toString();
    }

    @Override
    public boolean largerThan(T that) {
        return this.value > that.value;
    }

    @Override
    public boolean smallerThan(T that) {
        return this.value < that.value;
    }

    @Override
    public boolean largerEquals(T that) {
        return this.value >= that.value;
    }

    @Override
    public boolean smallerEquals(T that) {
        return this.value <= that.value;
    }

    @Override
    public boolean same(T that) {
        return this.value.equals(that.value);
    }

    protected abstract long maxLimit();
    protected abstract long minLimit();

    public boolean isValid() {
        if (this.value == null) return this.isNullable();
        return this.maxLimit() >= this.value && this.value >= this.minLimit();
    }
}
