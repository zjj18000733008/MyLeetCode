import sun.print.SunMinMaxPage;

import java.util.HashMap;
import java.util.List;

/**
 * @author JJ
 * @date 2020/8/29 - 22:15
 */
public class No120 {
    /**
     * 自底向上递推
     * 1、状态定义：
     * dp[i][j]dp[i][j]dp[i][j] 表示从点 (i,j)(i, j)(i,j) 到底边的最小路径和。
     * 2、状态转移：
     * dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
     *
     * @param triangle
     * @return
     */
    //执行用时：3 ms, 在所有 Java 提交中击败了73.69% 的用户
    //内存消耗：39.7 MB, 在所有 Java 提交中击败了86.98% 的用户
    public int minimumTotal(List<List<Integer>> triangle) {
//        int n=triangle.size();
//        int[][] dp=new int[n+1][n+1];
//        for (int i = n-1; i >=0 ; i--) {
//            for(int j=0;j<=i;j++){
//                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
//            }
//        }
//        return dp[0][0];

        //空间优化
        //执行用时：2 ms, 在所有 Java 提交中击败了95.33% 的用户
        //内存消耗：39.9 MB, 在所有 Java 提交中击败了53.71% 的用户
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了92.81% 的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了90.52% 的用户
     * 用动态规划从下往上递推
     * @author JJ
     * @date 2021/1/10 16:04
     */
    public int minimumTotal_2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size + 1];//用一维数组即可
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);//dp[j]...初始化默认为0;
            }
        }
        return dp[0];
    }

    /**
     * 递归解法
     * 执行用时：16 ms, 在所有 Java 提交中击败了5.18% 的用户
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败了5.04% 的用户
     * @author JJ
     * @date 2021/1/10 20:13
     */
    public int minimumTotal_3(List<List<Integer>> triangle) {
        return minimumTotal_3(triangle, 0, 0, triangle.size(), new HashMap<>());
    }

    public int minimumTotal_3(List<List<Integer>> triangle, int col, int row, int total, HashMap<String, Integer> map) {
        if (row + 1 == total) {
            return triangle.get(row).get(col);
        }
        String key = row + "-" + col;
        if (map.containsKey(key)) {//如果不使用map,执行效率将会非常低,因为很多元素会重复地向下递归
            return map.get(key);
        }
        int left = minimumTotal_3(triangle, col, row + 1, total, map);
        int right = minimumTotal_3(triangle, col + 1, row + 1, total, map);
        int sum=Math.min(left, right) + triangle.get(row).get(col);
        map.put(key, sum);
        return sum;
    }
}
