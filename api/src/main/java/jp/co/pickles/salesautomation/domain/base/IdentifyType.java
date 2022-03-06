package jp.co.pickles.salesautomation.domain.base;

public abstract class IdentifyType<T> extends PrimitiveType<T> {

    public IdentifyType(T value) {
        super(value);
    }

    public IdentifyType() {
    }

    public boolean isNotFound() {
        return this.isEmpty();
    }
}
