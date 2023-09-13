package solution;

import functions.*;
import interfaces.IFunction;
import modules.Menu;
import modules.Result;
import modules.Separation;
import modules.Data;

import java.util.ArrayList;
import java.util.Scanner;

public class Execution {
    Data data = new Data();
    Method method = new Method();

    void execute(IFunction func) {
        data.readData();
        if (method.checkValidValueArea(func, data.getA())) {
            System.out.println("Интервал не удовлетворяет ОДЗ");
        } else {
            ArrayList<Separation> array = method.findSeparations(func, data.getA(), data.getB());
            double sumInt = 0;
            if (array.get(0).isSecSeparation()) {
                System.out.println("Разрыв второго рода, ничего не считается");
            } else if (!method.checkSufficientCondition(func, data.getA(), data.getB())) {
                if (array.size() > 1) {
                    System.out.println("Присутствует разрыв первого рода, отрезок разбит на несколько частей");
                    for (Separation s : array) {
                        Result result = method.solveBySimpson(func, s.getA(), s.getB(), data.getEps());
                        sumInt += Math.abs(result.getIntegral());
                        System.out.println("Результаты для отрезка от " + s.getA() + " до " + s.getB() + ":");
                        result.print();
                        System.out.print("\n");
                    }
                    System.out.println("Общий результат");
                    System.out.println("Интеграл равен : " + sumInt);

                } else {
                    System.out.println("Выколота точка в начале или конце отрезка," +
                            " поэтому предел меняется на ближайшую подходящую точку");
                    Result result = method.solveBySimpson(func, array.get(0).getA(), array.get(0).getB(), data.getEps());
                    System.out.println("Результаты для отрезка от " + array.get(0).getA() + " до " + array.get(0).getB() + ":");
                    result.print();

                }

            } else {
                Result result = method.solveBySimpson(func, array.get(0).getA(), array.get(0).getB(), data.getEps());
                result.print();
            }
        }
    }

    public void go() {
        Menu menu = new Menu();
        Scanner in = new Scanner(System.in);
        menu.printMenu();
        String userInput = in.nextLine().trim();
        while (!userInput.equals("0")) {
            switch (userInput) {
                case "1":
                    FirstFunction f1 = new FirstFunction();
                    execute(f1);
                    menu.printMenu();
                    userInput = in.nextLine().trim();
                    break;
                case "2":
                    SecFunction f2 = new SecFunction();
                    execute(f2);
                    menu.printMenu();
                    userInput = in.nextLine().trim();
                    break;
                case "3":
                    ThirdFunction f3 = new ThirdFunction();
                    execute(f3);
                    menu.printMenu();
                    userInput = in.nextLine().trim();
                    break;
                case "4":
                    FourthFunction f4 = new FourthFunction();
                    execute(f4);
                    menu.printMenu();
                    userInput = in.nextLine().trim();
                    break;
                case "5":
                    FifthFunction f5 = new FifthFunction();
                    execute(f5);
                    menu.printMenu();
                    userInput = in.nextLine().trim();
                    break;

            }
        }

    }

}
