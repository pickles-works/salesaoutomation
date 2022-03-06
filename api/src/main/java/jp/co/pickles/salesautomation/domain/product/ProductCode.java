package jp.co.pickles.salesautomation.domain.product;

import jp.co.pickles.salesautomation.domain.base.StringType;

import java.util.regex.Pattern;

public class ProductCode extends StringType<ProductCode> {
    public ProductCode(String value) {
        super(value);
    }

    public ProductCode() {
    }

    @Override
    protected boolean isNullable() {
        return true;
    }

    @Override
    protected Pattern pattern() {
        return null;
    }
}
