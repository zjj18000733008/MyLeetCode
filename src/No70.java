/**
 * @author JJ
 * @date 2020/7/27 - 17:25
 */
public class No70 {

    /**
     * 标签：动态规划
     * 本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
     *
     *     爬上 n−1n-1n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
     *     爬上 n−2n-2n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
     *
     * 所以我们得到公式 dp[n]=dp[n−1]+dp[n−2]dp[n] = dp[n-1] + dp[n-2]dp[n]=dp[n−1]+dp[n−2]
     * 同时需要初始化 dp[0]=1dp[0]=1dp[0]=1 和 dp[1]=1dp[1]=1dp[1]=1
     * 时间复杂度：O(n)O(n)O(n)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n){
        int a=1,b=2;
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        for (int i = 3; i <=n ; i++) {
            int t=b;
            b=a+b;
            a=t;
        }
        return b;
    }

    public static void main(String[] args) {
        No70 no = new No70();
        System.out.println(no.climbStairs(3));
    }
}
