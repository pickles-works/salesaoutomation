package jp.co.pickles.salesautomation.testutils;

public class Result<T> {
    private final T response;
    private final Throwable exception;
    private final Type type;

    public Result(T response, Throwable exception, Type type) {
        this.response = response;
        this.exception = exception;
        this.type = type;
    }

    public T getResponse() {
        return this.response;
    }

    public boolean isSuccess() {
        return this.exception == null;
    }

    public <E extends Throwable> E castExceptionTo(Class<E> clazz) {
        return clazz.cast(this.exception);
    }

    public <E extends Throwable> boolean isErrorOf(Class<E> clazz) {
        return this.exception == null
                ? false
                : clazz.equals(this.exception.getClass());
    }

    public static <T> Result<T> success(T response, Type type) {
        return new Result<>(response, null, type);
    }

    public static <T> Result<T> failed(Throwable exception, Type type) {
        return new Result<>(null, exception, type);
    }

    public enum Type {
        正常, 準正常, 異常;
        private boolean isSuccess() {
            return this == 正常;
        }
    }
}
