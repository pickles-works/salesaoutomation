package jp.co.pickles.salesautomation.domain.product;

import jp.co.pickles.salesautomation.domain.base.UUIDType;

import java.util.UUID;

public class ProductID extends UUIDType<ProductID> {
    public ProductID(String value) {
        super(value);
    }

    public ProductID(UUID value) {
        super(value);
    }

    public ProductID() {
    }

    @Override
    protected boolean isNullable() {
        return true;
    }

    public static ProductID create() {
        return new ProductID(UUIDType.generate());
    }
}
