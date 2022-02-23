package PROGA.Classes.hw1;

public abstract class DefaultFunc<T,R>
        implements Func<T,R> {

    protected R value2;
    protected DefaultFunc insideFunc;

    public DefaultFunc(R value2) {
        this.value2 = value2;
    }

    public Func<T,T> identity() {
        Func<T,T> func = (Func<T, T>) this;
        return func;
    }

    public <V> Func<V,R> compose(Func<V,T> before) {
        insideFunc = (DefaultFunc) before;
        return (Func<V, R>) this;
    }

    public <V> Func<T, V> andThen(Func<R,V> after) {
        DefaultFunc<R,V> innerFunc = (DefaultFunc<R, V>) after;
        innerFunc.insideFunc = this;
        return (Func<T, V>) innerFunc;
    }
}
