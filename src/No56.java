import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author JJ
 * @date 2020/8/24 - 12:34
 */
public class No56 {

    //执行用时：8 ms, 在所有 Java 提交中击败了63.37% 的用户
    //内存消耗：42.6 MB, 在所有 Java 提交中击败了35.81% 的用户
    public int[][] merge(int[][] intervals) {

        ArrayList<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return res.toArray(new int[0][]);
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = res.get(res.size() - 1);
            if(intervals[i][0]<=ints[1]){
                ints[0]=Math.min(intervals[i][0],ints[0]);
                ints[1]=Math.max(intervals[i][1],ints[1]);
            }else{
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }


    public static void main(String[] args) {
        No56 no = new No56();
        int[][] arr = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15,18}
        };
        int[][] merge = no.merge(arr);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
