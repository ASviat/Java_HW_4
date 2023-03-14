/**
 * В калькулятор добавьте возможность отменить последнюю операцию.
 */
import java.util.Scanner;
import java.util.logging.*;

public class Task03 {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Task03.class.getName());
        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);

        SimpleFormatter sFormat = new SimpleFormatter();
        ch.setFormatter(sFormat);

        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число 1: ");
        int num1 = iScanner.nextInt();
        logger.info("Число 1 успешно введено.");
        System.out.println("Введите действие: ");
        char my_char = iScanner.next().charAt(0);
        logger.info("Действие успешно выбрано.");
        System.out.println("Введите число 2: ");
        int num2 = iScanner.nextInt();
        logger.info("Число  успешно введено.");
        iScanner.close();

        System.out.println("Ваш результат: ");

        switch (my_char) {
            case '+':
                System.out.println(num1 + num2);
                break;
            case '-':
                System.out.println(num1 - num2);
                break;
            case '*':
                System.out.println(num1 * num2);
                break;
            case '%':
                System.out.println(num1 % num2);
                break;
            case '/':
                System.out.println(num1 / num2);
                break;
        }
        logger.info("Результат предоставлен.");
    }
    
}