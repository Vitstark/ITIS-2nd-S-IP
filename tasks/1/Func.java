package PROGA.Classes.hw1;

public interface Func<T,R>{

    R apply(T t);

    Func<T,T> identity();

    <V> Func<V,R> compose(Func<V,T>  before);

    <V> Func<T,V> andThen(Func<R,V> after);

}
