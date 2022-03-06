package jp.co.pickles.salesautomation.domain.product;

import jp.co.pickles.salesautomation.domain.base.LongType;

public class ProductLimitOfQuantity extends LongType<ProductLimitOfQuantity> {
    public ProductLimitOfQuantity(Long value) {
        super(value);
    }

    public ProductLimitOfQuantity() {
    }

    @Override
    protected long maxLimit() {
        return Long.MAX_VALUE;
    }

    @Override
    protected long minLimit() {
        return 0;
    }

    @Override
    protected boolean isNullable() {
        return false;
    }
}
