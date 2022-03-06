package jp.co.pickles.salesautomation.domain.base;

public abstract class NumberIDType<T extends NumberIDType<T>> extends IdentifyType<Long> {
    public NumberIDType(Long value) {
        super(value);
    }

    public NumberIDType() {
    }

    @Override
    public boolean isValid() {
        if (this.value == null) return this.isNullable();
        return true;
    }
}
