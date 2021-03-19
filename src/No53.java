
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 最大子序和
 *
 * @author JJ
 * @date 2020/7/19 - 9:19
 */
public class No53 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums={1,2};
//        int[] nums = {-2, -1};
//        int[] nums={-1};
        No53 no = new No53();
//        System.out.println(no.maxSubArray_2(nums));
        System.out.println(no.maxSubArray3(nums));
    }

    public int maxSubArray(int[] nums) {

        if (nums.length == 0) return -2147483648;
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum <= 0) {
                sum = num;
            } else {
                sum += num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了93.30% 的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了68.73% 的用户
     *
     * @author JJ
     * @date 2021/1/10 15:02
     */
    public int maxSubArray_2(int[] nums) {

        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        //初始化
        dp[0] = nums[0];
        max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了94.82% 的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了94.58% 的用户
     * @author JJ
     * @date 2021/3/18 20:33
     */
    public int maxSubArray3(int[] nums){

        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int ans=dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=nums[i]+Math.max(dp[i-1],0);
            if(dp[i]>ans){
                ans=dp[i];
            }
        }

        return ans;
    }
}
