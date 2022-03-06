package jp.co.pickles.salesautomation.domain.base;

import java.util.regex.Pattern;

public abstract class StringType<T extends StringType<T>> extends PrimitiveType<String> implements ValueObject<T> {
    private static final Pattern DEFAULT_PATTERN = Pattern.compile(".*");
    public StringType(String value) {
        super(value);
    }

    public StringType() {
    }

    @Override
    public String asText() {
        return this.toString();
    }

    @Override
    public boolean same(T that) {
        return this.value.equals(that.value);
    }

    // 参考: https://qiita.com/opengl-8080/items/f68829533ce042c38266
    protected abstract Pattern pattern();

    private Pattern getPattern() {
        return this.pattern() == null
                ? DEFAULT_PATTERN
                : this.pattern();
    }

    @Override
    public boolean isValid() {
        if (this.value == null) return this.isNullable();
        return this.getPattern().matcher(this.value).matches();
    }
}
