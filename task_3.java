// 3) К калькулятору из предыдущего ДЗ добавить логирование.
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class task_3 {
    //3) Реализовать простой калькулятор
    public static void main(String[] args) {

        int x1 = GetInt();
        int x2 = GetInt();
        char operation = GetOperation();
        int result = calc(x1, x2, operation);
        Logger logger = Logger.getLogger(task_3.class.getName());
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        try {
            FileHandler fh = new FileHandler("calc.log");
            logger.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
        } catch (IOException ioex) {
            logger.log(Level.SEVERE, "Can't create log file handler", ioex);
        }
        System.out.println("Итог: " + result);
        logger.log(Level.INFO, "The result is " + result);

    }
    public static int GetInt() {
        System.out.print("Введите целое число:");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        return x;
    }

    public static char GetOperation() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите желаемое действие(Калькулятор может выполнить только следующие " +
                "действия (*,/,+,-)): ");
        char operation = in.next().charAt(0);
        return operation;
    }

    public static int calc(int x1, int x2, char operation) {
        Logger logger = Logger.getLogger(task_3.class.getName());
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        try {
            FileHandler fh = new FileHandler("calc.log");
            logger.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
        } catch (IOException ioex) {
            logger.log(Level.SEVERE, "Can't create log file handler", ioex);
        }
        int res = 0;
        switch (operation){
            case '+':
                res = x1 + x2;
                break;
            case '-':
                res = x1 - x2;
                break;
            case '*':
                res = x1 * x2;
                break;
            case '/':
                res = x1 / x2;
                break;
            default:
                System.out.println("Введены неверные данные");
                logger.log(Level.WARNING, "Expression was wrong!");
        }
        return res;
    }
}
