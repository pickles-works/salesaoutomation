package jp.co.pickles.salesautomation.domain.base;

public interface ValueObject<T> {
    boolean same(T that);
    String asText();
}
