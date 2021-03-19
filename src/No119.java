import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JJ
 * @date 2020/7/29 - 9:16
 */
public class No119 {

    public List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        if (rowIndex == 0) {
            queue.add(1);
            return queue;
        } else if (rowIndex >= 1) {
            queue.add(1);
            queue.add(1);
        }
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    queue.add(1);
                } else {
                    queue.add(queue.poll() + queue.peek());
                }
            }
            queue.poll();
        }

        return queue;
    }

    public static void main(String[] args) {
        No119 no = new No119();
        List<Integer> row = no.getRow(0);
        for (Integer integer : row) {
            System.out.println(integer);
        }
    }
}
