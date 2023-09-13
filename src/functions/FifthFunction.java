package functions;

import interfaces.IFunction;

public class FifthFunction implements IFunction {
    @Override
    public Double f(double x) {
        return Math.sqrt(x);
    }
}
