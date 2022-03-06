package jp.co.pickles.salesautomation.domain.product;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class ProductName extends StringType<ProductName> {
    public ProductName(String value) {
        super(value);
    }

    public ProductName() {
    }

    @Override
    protected Pattern pattern() {
        return null;
    }

    @Override
    protected boolean isNullable() {
        return false;
    }
}
