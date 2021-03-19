/**
 * @author JJ
 * @date 2020/8/24 - 21:44
 */
public class No64 {
    //执行用时：3 ms, 在所有 Java 提交中击败了87.72% 的用户
    //内存消耗：42.6 MB, 在所有 Java 提交中击败了37.29% 的用户
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(j - 1 < 0 ? Integer.MAX_VALUE : dp[i][j - 1], i - 1 < 0 ? Integer.MAX_VALUE : dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 执行用时：103 ms, 在所有 Java 提交中击败了14.60% 的用户
     * 内存消耗：40.6 MB, 在所有 Java 提交中击败了99.23% 的用户
     * 动态规划
     * @author JJ
     * @date 2021/1/10 20:50
     */
    public int minPathSum_2(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0){
                    dp[i][j]=grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min((i - 1 < 0) ? Integer.MAX_VALUE : dp[i - 1][j], (j - 1 < 0) ? Integer.MAX_VALUE : dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        No64 no = new No64();
        int[][] arr = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int result = no.minPathSum_2(arr);
    }
}
