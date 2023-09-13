package modules;

public class Separation {
    double left;
    double right;
    boolean secSeparation = false;


    public Separation(double a, double b) {
        this.left = a;
        this.right = b;
    }

    public double getA() {
        return left;
    }

    public double getB() {
        return right;
    }

    public void setSecSeparation(boolean secSeparation) {
        this.secSeparation = secSeparation;
    }

    public boolean isSecSeparation() {
        return secSeparation;
    }
}
