/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/3
 */
public class No200 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了70.73% 的用户
     * 内存消耗：46.6 MB, 在所有 Java 提交中击败了5.05% 的用户
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int count=0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    public  void dfs(int i,int j,char[][] grid){

        int m=grid.length;
        int n=grid[0].length;

        grid[i][j]=0;

        // 上
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(i, j-1, grid);
        }

        // 下
        if (j + 1 < n && grid[i][j + 1] == '1') {
            dfs(i, j+1, grid);
        }
        // 左
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(i-1, j, grid);
        }
        // 右
        if (i + 1 < m && grid[i + 1][j] == '1') {
            dfs(i+1, j, grid);
        }
    }
}
