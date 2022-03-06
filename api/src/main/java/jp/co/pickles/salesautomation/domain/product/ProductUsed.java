package jp.co.pickles.salesautomation.domain.product;

import jp.co.pickles.salesautomation.domain.base.EnumType;

public class ProductUsed extends EnumType<ProductUsed, ProductUsed.Type> {
    public ProductUsed(String value) {
        super(Type.valueOf(value));
    }

    public ProductUsed(Type value) {
        super(value);
    }

    public ProductUsed() {
    }

    @Override
    protected boolean isNullable() {
        return false;
    }

    public enum Type {
        NEW, USED, DISPLAYED
    }
}
