/**
 * @author JJ
 * @date 2020/8/24 - 21:06
 */
public class No63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                if(i==0 || j==0){
//                    dp[i][j]=1;
//                }else{
//                    dp[i][j]=
//                            (j-1<0?0:(obstacleGrid[i][j-1]==1?0:dp[i][j-1]))
//                                    +(obstacleGrid[i-1][j]==1?0:dp[i-1][j]);
//                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] =
                        (j - 1 < 0 ? 0 : (obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1]))
                                + (i - 1 < 0 ? 0 : (obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j]));
            }
        }
        return obstacleGrid[m - 1][n - 1] == 1 ? 0 : dp[m - 1][n - 1];
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了17.91% 的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了44.16% 的用户
     * @author JJ
     * @date 2021/1/11 13:00
     */
    public int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                dp[i][j] = (i-1<0 || obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j]) + (j-1<0 || obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1]);
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

        No63 no = new No63();
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int i = no.uniquePathsWithObstacles(arr);
        System.out.println(i);
    }
}
