package solution;

import interfaces.IFunction;
import modules.Result;
import modules.Separation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Method {
    private double calculateBySimpson(IFunction f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = f.f(a) + f.f(b);
        double k;
        for (int i = 1; i < n - 1; i++) {
            k = 2 + 2 * (i % 2);
            sum += k * f.f(a + i * h);
        }
        sum *= h / 3;
        return sum;
    }

    public Result solveBySimpson(IFunction f, double a, double b, double eps) {
        int k = 1;

        double sum2 = calculateBySimpson(f, a, b, k);
        double sum1;
        do {
            k *= 2;
            sum1 = sum2;
            sum2 = calculateBySimpson(f, a, b, k);

        } while (Math.abs(sum1 - sum2) > eps);
        return new Result(sum2, k);

    }

    public boolean checkValidValueArea(IFunction func, double a) {
        if (func.f(a).isNaN() && func.f(a + 0.0001).isNaN()) {
            return true;
        } else
            return false;
    }

    public ArrayList<Separation> findSeparations(IFunction func, double a, double b) {
        ArrayList<Separation> array = new ArrayList<>();
        double eps = 0.00000001;
        double left_now = func.f(a).isNaN() || func.f(a).isInfinite() ? a + eps : a;
        if (a <= b) {
            for (double i = a + 0.001d; i < b; i += 0.001d) {
                i = (new BigDecimal(Double.toString(i))).setScale(4, RoundingMode.HALF_UP).doubleValue();
                if (func.f(i).isNaN() || func.f(i).isInfinite()) {
                    array.add(new Separation(left_now, i - eps));
                    left_now = i + eps;
                }
                if (func.f(i).isInfinite()) {
                    array.get(0).setSecSeparation(true);
                }
            }
        } else {
            for (double i = a; i > b; i -= 0.0001) {
                if (func.f(i).isNaN() || func.f(i).isInfinite()) {
                    array.add(new Separation(left_now, i + eps));
                    left_now = i - eps;
                }
            }
        }

        Double end = func.f(b);
        end = end.isNaN() || end.isInfinite() ? b - eps : b;
        array.add(new Separation(left_now, end));
        return array;
    }

    public boolean checkSufficientCondition(IFunction func, double a, double b) {
        boolean isContinuous = true;
        if (a <= b) {
            for (double i = a; i <= b; i += 0.001d) {
                i = (new BigDecimal(Double.toString(i))).setScale(4, RoundingMode.HALF_UP).doubleValue();
                if (func.f(i).isNaN() || func.f(i).isInfinite()) {
                    isContinuous = false;
                }
            }
        } else {
            for (double i = a; i >= b; i -= 0.0001) {
                if (func.f(i).isNaN() || func.f(i).isInfinite()) {
                    isContinuous = false;
                }
            }
        }

        return isContinuous;
    }


}
