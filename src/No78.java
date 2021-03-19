import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2020/8/25 - 12:19
 */
public class No78 {

    List<List<Integer>> lists = new ArrayList<>();

    //执行用时：1 ms, 在所有 Java 提交中击败了99.35% 的用户
    //内存消耗：39.9 MB, 在所有 Java 提交中击败了73.68% 的用户
    public List<List<Integer>> subsets(int[] nums) {

        for (int i = 0; i <=nums.length; i++) {
            backtrack(nums, i, new ArrayList<>(), 0, 0);
        }
        return lists;
    }

    /**
     *
     * @param nums
     * @param n 当前要找的子集是几位的?0,1,2...
     * @param list
     * @param start
     * @param count
     */
    private void backtrack(int[] nums, int n, List<Integer> list, int start, int count) {
        if (count == n) {
            lists.add(new ArrayList<>(list));
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, n, list, i + 1, count + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        No78 no = new No78();
        int[] arr = {1, 2, 3};
        List<List<Integer>> lists = no.subsets(arr);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

class No78_2{

    List<List<Integer>> lists=new ArrayList<>();

    /**
     * 回溯算法
     * 执行用时：1 ms, 在所有 Java 提交中击败了85.63% 的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了17.01% 的用户
     * @author JJ
     * @date 2021/1/14 21:02
     */
    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            backtrack(nums,i,0 ,0,new ArrayList<>());
        }
        return lists;
    }

    public void backtrack(int[] nums,int n,int count,int start,List<Integer> list){
        if(count==n){
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums,n,count+1,i+1,list);
            list.remove(list.size()-1);
        }

    }
    public static void main(String[] args) {
        No78_2 no = new No78_2();
        int[] arr = {1, 2, 3};
        List<List<Integer>> lists = no.subsets(arr);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

class No78_3{

    /**
     * 位运算
     * 执行用时：1 ms, 在所有 Java 提交中击败了85.63% 的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了8.58% 的用户
     * @author JJ
     * @date 2021/1/14 21:23
     */
    public List<List<Integer>> subsets(int[] nums) {
       int length=1<<nums.length;//1*(2^nums.lenth) 数组长为n,则有2^n中组合  二进制
        List<List<Integer>> lists=new ArrayList<>(length);
        //每个i对应的二进制数,哪一位出现1就将对应数组中的哪一位放入list
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> list= new ArrayList<>();
            //每次把i对应的二进制数向右移j位-->相当于从右开始,每次选择i对应的二进制数的一位
            //每次把i对应的二进制数向右移j位,与1进行按位与运算-->相当于判断该位是否为1
            for (int j = 0; j < nums.length; j++) {
                //数字i上的哪一位为1,就将nums对应的数放入数组
                if(((i>>j) & 1)==1){
                    list.add(nums[j]);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        No78_3 no = new No78_3();
        int[] arr = {1, 2, 3};
        List<List<Integer>> lists = no.subsets(arr);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
