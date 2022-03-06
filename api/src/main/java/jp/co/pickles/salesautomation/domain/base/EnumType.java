package jp.co.pickles.salesautomation.domain.base;

public abstract class EnumType<T extends EnumType<T, E>, E extends Enum<E>> extends PrimitiveType<E> implements ValueObject<T> {
    public EnumType(E value) {
        super(value);
    }

    public EnumType() {
    }

    @Override
    public String asText() {
        return this.value == null
                ? ""
                : this.value.name();
    }

    @Override
    public boolean same(T that) {
        return this.value == that.value;
    }

    @Override
    public boolean isValid() {
        if (this.value == null) return this.isNullable();
        return true;
    }
}
