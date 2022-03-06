package jp.co.pickles.salesautomation.domain.base;

public abstract class PrimitiveType<T> {
    protected final T value;

    public PrimitiveType(T value) {
        this.value = value;
    }

    public PrimitiveType() {
        this.value = null;
    }

    public T getValue() {
        return value;
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrimitiveType<?> that = (PrimitiveType<?>) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return this.value != null ? value.toString() : "";
    }

    protected abstract boolean isNullable();
    public abstract boolean isValid();
}
