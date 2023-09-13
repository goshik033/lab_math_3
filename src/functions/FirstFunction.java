package functions;

import interfaces.IFunction;

public class FirstFunction implements IFunction {

    public Double f(double x) {
        return Math.sin(x);
    }
}
