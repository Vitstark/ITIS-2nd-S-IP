package PROGA.Classes.hw1;

public class Option<T> {

    T value;

    public static <T> T empty() {
        return null;
    }

    public boolean isEmpty() {
        if (value == null) {
            return true;
        }
        return false;
    }

    public boolean isPresent() {
        if (value != null) {
            return true;
        }
        return false;
    }

    public T orElse(T other) {
        if (isEmpty()) {
            return other;
        }
        return value;
    }

    public <U> Option<U> map(Func<T,U> mapper) {

        if (isEmpty()) {
            return null;
        }

        Option<U> option = new Option<>();
        option.value = mapper.apply(value);
        return option;
    }
}
