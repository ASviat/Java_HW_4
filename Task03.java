
/**
 * В калькулятор добавьте возможность отменить последнюю операцию.
 */
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.*;

public class Task03 {

    public static void main(String[] args) throws SecurityException, IOException {
        Scanner iScanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(Task03.class.getName());
        FileHandler fh = new FileHandler("Task03_log.txt");
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        LinkedList<Integer> myList = new LinkedList<Integer>();
        myList = CalcIt(logger, iScanner, myList);
        iScanner.close();
    }

    public static LinkedList<Integer> CalcIt(Logger logger, Scanner x, LinkedList<Integer> mList) {

        System.out.println("Введите b для отмены последней операции, Введите q для выхода из программы");

        System.out.println("Введите число 1: ");
        String num1 = x.next();

        if (IsDigit(num1)) {
            logger.info("Число 1 успешно введено.");
            System.out.println("Введите действие: ");
            char my_char = x.next().charAt(0);
            logger.info("Действие успешно выбрано.");
            System.out.println("Введите число 2: ");
            String num2 = x.next();

            if (IsDigit(num2)) {
                logger.info("Число  успешно введено.");

                switch (my_char) {
                    case '+':
                        mList.add(Integer.parseInt(num1) + Integer.parseInt(num2));
                        break;
                    case '-':
                        mList.add(Integer.parseInt(num1) - Integer.parseInt(num2));
                        break;
                    case '*':
                        mList.add(Integer.parseInt(num1) * Integer.parseInt(num2));
                        break;
                    case '%':
                        mList.add(Integer.parseInt(num1) % Integer.parseInt(num2));
                        break;
                    case '/':
                        mList.add(Integer.parseInt(num1) / Integer.parseInt(num2));
                        break;
                }
                logger.info("Результат предоставлен.");
                
                System.out.printf("%s %c %s = %s\n", num1, my_char, num2, mList.getLast());
                return CalcIt(logger, x, mList);

            } else {
                System.out.println("Введите число!");
                return CalcIt(logger, x, mList);
            }
        } else {
            if (num1.equals("q")) {
                logger.info("Выход выполнен.");
                return mList;
            }
            if (num1.equals("b")) {
                mList.removeLast();
                System.out.printf("Последний результат до отмены действия: %s\n", mList.getLast());
                logger.info("Действие отменено.");
                return CalcIt(logger, x, mList);
            }
            System.out.println("Моя твоя не понимать");
            return CalcIt(logger, x, mList);
        }
    }

    private static boolean IsDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
