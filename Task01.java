import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который
 * вернёт «перевёрнутый» список.
 */
public class Task01 {

    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<Integer>();
        Random rnd = new Random();
        Scanner myInput = new Scanner(System.in);
        System.out.println("Сколько элементов будем переворачивать? ");
        int arrayLength = myInput.nextInt();
        myInput.close();
        for (int i = 0; i < arrayLength; i++) {
            myList.add(rnd.nextInt(0, 101));
        }
        System.out.println(myList);
        myList.sort(null);
        System.out.println(myList);
    }
}