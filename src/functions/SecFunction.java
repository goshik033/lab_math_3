package functions;

import interfaces.IFunction;

public class SecFunction implements IFunction {

    @Override
    public Double f(double x) {
        return Math.sin(x) / x;
    }
}
