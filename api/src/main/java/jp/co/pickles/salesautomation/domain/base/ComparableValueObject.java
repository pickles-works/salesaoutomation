package jp.co.pickles.salesautomation.domain.base;

public interface ComparableValueObject<T> extends ValueObject<T> {
    boolean largerThan(T that);
    boolean smallerThan(T that);
    boolean largerEquals(T that);
    boolean smallerEquals(T that);
}
