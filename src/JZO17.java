import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/18
 */
public class JZO17 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.40% 的用户
     * 内存消耗：46.8 MB, 在所有 Java 提交中击败了13.97% 的用户
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int x=1;
        while(n>0){
            x*=10;
            n--;
        }
        int[] arr = new int[x - 1];
        for (int i = 1; i < x; i++) {
            arr[i-1]=i;
        }
        return arr;
    }

    @Test
    public void test(){
        int[] arr = printNumbers(3);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
