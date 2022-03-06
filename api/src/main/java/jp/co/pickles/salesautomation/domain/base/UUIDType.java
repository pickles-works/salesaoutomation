package jp.co.pickles.salesautomation.domain.base;

import java.util.UUID;

public abstract class UUIDType<T extends UUIDType<T>> extends IdentifyType<UUID> implements ValueObject<T> {
    public UUIDType(String value) {
        super(UUID.fromString(value));
    }

    public UUIDType(UUID value) {
        super(value);
    }

    public UUIDType() {
    }

    @Override
    public String asText() {
        return this.toString();
    }

    @Override
    public boolean same(T that) {
        return this.value.equals(that.value);
    }

    @Override
    public boolean isValid() {
        if (this.value == null) return this.isNullable();
        return true;
    }

    protected static UUID generate() {
        return UUID.randomUUID();
    }
}
