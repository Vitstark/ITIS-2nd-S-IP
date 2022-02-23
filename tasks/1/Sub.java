package PROGA.Classes.hw1;

public class Sub
        extends DefaultFunc<Integer, Integer> {

    public Sub(Integer value) {
        super(value);
    }

    public Integer apply(Integer value) {

        if (insideFunc == null) {
            return value - value2;
        }

        DefaultFunc<Integer,Integer> func = (DefaultFunc<Integer,Integer>) insideFunc;

        insideFunc = null;

        return func.apply(value) - value2;
    }

}
