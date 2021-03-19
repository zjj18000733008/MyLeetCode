/**
 * @author JJ
 * @date 2020/8/24 - 12:15
 */
public class No55 {


    //执行用时：1 ms, 在所有 Java 提交中击败了99.98% 的用户
    //内存消耗：41.9 MB, 在所有 Java 提交中击败了34.21% 的用户
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return true;
        int count = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                count++;
            } else if (nums[i] > count) {
                count = 0;
            } else {
                count++;
            }
        }
        if (count == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        No55 no = new No55();
        int[] arr = {2, 3, 1, 1, 4};
        boolean b = no.canJump(arr);
        System.out.println(b);
    }
}
