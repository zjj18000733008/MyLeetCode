/**
 * @author JJ
 * @date 2020/8/24 - 13:40
 */
public class No62 {

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：36.5 MB, 在所有 Java 提交中击败了43.48% 的用户
    public int uniquePaths(int m,int n){
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 || j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths3(int m,int n){

        return 0;
    }
}
