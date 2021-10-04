/**
 * @author JJ
 * @date 2020/8/4 - 17:05
 */
public class No268 {
    //执行用时：1 ms, 在所有 Java 提交中击败了51.50% 的用户
    //内存消耗：40 MB, 在所有 Java 提交中击败了91.24% 的用户
    public int missingNumber(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            count1 += i;
            count2 += nums[i];
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (count1 == count2) {
            return max + 1;
        }
        count1 += max;
        return count1 - count2;
    }
    //执行用时：1 ms, 在所有 Java 提交中击败了51.50% 的用户
    //内存消耗：40.4 MB, 在所有 Java 提交中击败了39.10% 的用户
    public int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i] ^ i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2};
        No268 no = new No268();
        int i = no.missingNumber(arr);
        System.out.println(i);
    }
}
