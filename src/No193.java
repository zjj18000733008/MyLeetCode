/**
 * @author JJ
 * @date 2020/7/31 - 10:47
 */
public class No193 {
    public int rob(int[] nums) {
        /**
         * 读题知输入一个长度为 n 的数组，表示 n 个房屋，让我们求到第 n 个房屋的最大金额。
         * 我们想一下到第n个房屋的最大金额 dp[n]:
         * 1.如果偷第 n 个房屋的话，由于相邻的房屋不能偷，
         * 所以 dp[n] = dp[n - 2] + nums[n]
         * （即等于到第 n - 2 个房屋的最大金额 + 第 n 个房屋的金额）
         * 2. 反之如果不偷第 n 个房屋的话，那么 dp[n] = dp[n - 1]
         * （即等于到第 n - 1 个房屋的最大金额）
         * 于是，我们得到了状态转移方程：dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
         */
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
//        int[] arr={1,2,3,1};
//        int[] arr={2,1,1,2};
        int[] arr={1,3,1};
        No193 no193 = new No193();
        int rob = no193.rob(arr);
        System.out.println(rob);
    }
}
