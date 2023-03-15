
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
        int count = 0;
        myList = CalcIt(logger, iScanner, myList, count);
        iScanner.close();
    }

    public static LinkedList<Integer> CalcIt(Logger logger, Scanner x, LinkedList<Integer> mList, int countIt) {

        if (countIt == 0)
            System.out.println("Введите число 1: ");
        else {

            System.out
                    .println("Info. Введите b для отмены последней операции\nInfo. Введите q для выхода из программы.");
            System.out.println();
            System.out.println("Введите число или действие(+, -, *, %, /) с полученным значением: ");
        }
        String num1 = x.next();
        if (IsDigit(num1)) {
            logger.info("Введен int в качестве 1 числа.");
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
                countIt++;
                return CalcIt(logger, x, mList, countIt);

            } else {
                logger.info("Ошибка! Введено некорректное значение.");
                System.out.println("Введите число!");
                return CalcIt(logger, x, mList, countIt);
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
                countIt--;
                return CalcIt(logger, x, mList, countIt);
            }
            if (num1.equals("+") || num1.equals("-") || num1.equals("*")
                    || num1.equals("%") || num1.equals("/")) {
                logger.info("Выбрано действие с предыдущим значением. ");
                System.out.println("Введите число: ");
                String num2 = x.next();
                if (IsDigit(num2)) {
                    logger.info("Введено значение для взаимодействия с предыдущим. ");
                    switch (num1) {
                        case "+":
                            mList.add(mList.peekLast() + Integer.parseInt(num2));
                            break;
                        case "-":
                            mList.add(mList.peekLast() - Integer.parseInt(num2));
                            break;
                        case "*":
                            mList.add(mList.peekLast() * Integer.parseInt(num2));
                            break;
                        case "%":
                            mList.add(mList.peekLast() % Integer.parseInt(num2));
                            break;
                        case "/":
                            mList.add(mList.peekLast() / Integer.parseInt(num2));
                            break;

                    }
                    logger.info("Результат предоставлен.");

                    System.out.printf("%s %s %s = %s\n", mList.get(countIt - 1), num1, num2, mList.getLast());
                    countIt++;
                    return CalcIt(logger, x, mList, countIt);
                }
            }
            System.out.println("Моя твоя не понимать");
            logger.info("Ошибка! Необработанное взаимодействие. ");
            return CalcIt(logger, x, mList, countIt);
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
