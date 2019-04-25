package collections.Q1;

/**
 *
 * @author hp
 */
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class Q1 {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        Random r = new Random();
        int random;
        int sum = 0;

        for (int i = 0; i < 25; i++) {
            random = r.nextInt(100);
            linkedList.add(random);
        }

        System.out.println("LinkedList befor sort:");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }

        System.out.println("\n-----------------------------------------------");

        linkedList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 > o1) {
                    return 1;
                } else if (o2 < o1) {
                    return -1;
                }
                return 0;
            }
        });
        System.out.println("LinkedList After sort:");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
            sum += linkedList.get(i);
        }

        System.out.println("\n-----------------------------------------------");
        System.out.println("The sum of the elements is : " + sum);
        System.out.println("The floating-point average of the elements is : " + (sum / 25));
    }
}
