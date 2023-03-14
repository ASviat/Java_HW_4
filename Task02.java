import java.util.LinkedList;

/**
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * • enqueue() — помещает элемент в конец очереди,
 * • dequeue() — возвращает первый элемент из очереди и удаляет его,
 * • first() — возвращает первый элемент из очереди, не удаляя.
 */
public class Task02 {

    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<String>();

        myList.add("First");
        myList.add("Second");
        myList.add("Third");

        System.out.printf("List defore methods: %s\n", myList);

        System.out.printf("After enqueue: %s\n", enqueue(myList));
        System.out.printf("After dequeue: %s\n", dequeue(myList));
        System.out.printf("After method first(): %s", first(myList));

    }

    public static LinkedList<String> enqueue(LinkedList<String> mList) {

        mList.offerLast("First");
        mList.removeFirst();
        return mList;
    }

    public static LinkedList<String> dequeue(LinkedList<String> mList) {
        mList.remove();
        return mList;
    }

    public static String first(LinkedList<String> mList) {
        return mList.element();
    }
}