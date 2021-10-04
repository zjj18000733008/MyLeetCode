import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/6
 */
public class No147 {

    public int minmumNumberOfHost(int n, int[][] startEnd) {

        Arrays.sort(startEnd, (int[] a, int[] b) -> {
            if (a[0] < 0 && b[0] > 0) { // 防止溢出
                return -1;
            } else if (a[0] > 0 && b[0] < 0) { // 防止溢出
                return 1;
            }else if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < startEnd.length; i++) {
            if (!queue.isEmpty() && queue.peek() <= startEnd[i][0]) {
                queue.poll();
            } else {
                ans++;
            }
            queue.add(startEnd[i][1]);
        }

        return ans;
    }

    @Test
    public void test(){
        Assert.assertEquals(1, minmumNumberOfHost(2, new int[][] {
                {1, 2}, {2, 3}
        }));
        Assert.assertEquals(2, minmumNumberOfHost(2, new int[][] {
                {1, 3}, {2, 4}
        }));
        Assert.assertEquals(5, minmumNumberOfHost(10, new int[][] {
                {2147483646,2147483647},{-2147483648,-2147483647},
                {2147483646,2147483647},{-2147483648,-2147483647},
                {2147483646,2147483647},{-2147483648,-2147483647},
                {2147483646,2147483647},{-2147483648,-2147483647},
                {2147483646,2147483647},{-2147483648,-2147483647}
        }));

    }

}
