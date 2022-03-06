package jp.co.pickles.salesautomation.domain.account;

import jp.co.pickles.salesautomation.domain.base.EnumType;

public class Locked extends EnumType<Locked, Locked.Type> {
    public Locked(Type value) {
        super(value);
    }

    public Locked() {
    }

    public boolean isLocked() {
        return this.value == Type.LOCKED;
    }

    public boolean isNotLocked() {
        return this.value == Type.NOT_LOCKED;
    }

    @Override
    protected boolean isNullable() {
        return false;
    }

    public enum Type {
        LOCKED, NOT_LOCKED
    }
}
