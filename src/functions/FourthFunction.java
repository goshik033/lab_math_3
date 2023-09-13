package functions;

import interfaces.IFunction;

public class FourthFunction implements IFunction {
    @Override
    public Double f(double x) {
        return 1 / x;
    }
}
