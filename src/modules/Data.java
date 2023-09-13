package modules;

import java.util.Scanner;

public class Data {
    private double eps;
    private double a;
    private double b;

    private Double inputData() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String str = in.nextLine();
                double num = Double.parseDouble(str);
                return num;
            } catch (NumberFormatException wrongForm) {
                System.out.println("Неверный формат, попробуйте еще раз");

            }
        }
    }

    public void readData() {
        System.out.println("Введите a границу");
        a = inputData();
        System.out.println("Введите b границу");
        b = inputData();
        System.out.println("Введите точность:");
        eps = inputData();
    }

    public double getEps() {
        return eps;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
