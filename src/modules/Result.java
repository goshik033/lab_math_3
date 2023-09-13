package modules;

public class Result {
    double integral;
    int segments;

    public Result(double integral, int segments) {
        this.integral = Math.abs(integral);
        this.segments = segments;
    }

    public double getIntegral() {
        return integral;
    }

    public int getSegments() {
        return segments;
    }

    public void print() {
        System.out.println("Количество промежутков разбиения : " + segments);
        System.out.println("Интеграл равен : " + integral);
    }
}