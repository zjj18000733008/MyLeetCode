import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 * 剑指 Offer 04. 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * @author zhongjunjie
 * @Date: 2021/10/12
 */
public class JZO04 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：43.8 MB, 在所有 Java 提交中击败了92.73% 的用户
     *
     * 二维数组中每个元素的左边元素一定比它小, 下边元素一定比它大
     * 利用二分查找树的思想, 如果目标target比当前值大就选择下边元素, 如果目标值target比当前值小就选择左边元素,直到找到目标值
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length==0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] flag = new int[n][m];

        int i = 0;
        int j = matrix[0].length - 1;

        while (i < n && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }

        return false;
    }

    @Test
    public void test() {
        Assert.assertTrue(findNumberIn2DArray(new int[][] {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 3}
        },5));
        Assert.assertFalse(findNumberIn2DArray(new int[][] {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 3}
        },20));
        Assert.assertFalse(findNumberIn2DArray(new int[][] {

        },0));


    }

}
