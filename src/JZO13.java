import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/13
 */
public class JZO13 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了60.83% 的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了14.29% 的用户
     *
     * 扩散遍历法
     * 每次判断自身是否符合要求,
     * 如果自身符合要求则sum=1, 然后遍历四周,返回的sum等于 当前1 + 四周的返回值;
     * 如果自身不符合要求则返回0
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        return dfs(m, n, k, 0, 0, new int[m][n]);
    }

    private int dfs(int m ,int n,int k,int i, int j,int[][] visited) {

        if (i < 0 || j < 0 || i >= m || j >= n || !available(i,j,k) || visited[i][j]==1) {
            return 0;
        }
        System.out.println("i="+i+",j="+j);

        visited[i][j]=1;
        int sum=1;

        // top
        sum+=dfs(m, n, k, i-1, j, visited);

        // right
        sum+=dfs(m, n, k, i, j+1, visited);

        // down
        sum+=dfs(m, n, k, i+1, j, visited);

        // left
        sum+=dfs(m, n, k, i, j-1, visited);

        return sum;

    }

    private boolean available(int i,int j,int k){

        return getSum(i)+getSum(j)<=k;
    }

    private int getSum(int i){

        int sum=0;
        while(i!=0){
            sum+=i%10;
            i=i/10;
        }
        return sum;
    }

    @Test
    public void testGetSum(){
        Assert.assertEquals(8, getSum(35));
        Assert.assertEquals(2, getSum(2));
        Assert.assertEquals(1, getSum(1));
    }

    @Test
    public void test(){
//        Assert.assertEquals(3, movingCount(2, 3, 1));
//        Assert.assertEquals(6, movingCount(3, 2, 17));
        Assert.assertEquals(7, movingCount(7, 2, 3));
    }
}
