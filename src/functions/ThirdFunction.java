package functions;

import interfaces.IFunction;

public class ThirdFunction implements IFunction {

    @Override
    public Double f(double x) {
        return x / Math.abs(x);
    }
}
