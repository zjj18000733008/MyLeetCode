
import java.util.logging.XMLFormatter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/6
 */
public class No50 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.5 MB, 在所有 Java 提交中击败了50.77% 的用户
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        return myPow(x, (long)n);
    }

    public double myPow(double x,long n){
        if (n < 0) {
            return 1 / myPow(x, -n);
        } else if (n == 0) {
            return 1;
        } else {
            if (n % 2 == 0) {
                double v = myPow(x, n / 2);
                return v * v;
            } else {
                double v = myPow(x, (n - 1) / 2);
                return v * v * x;
            }
        }
    }

    @Test
    public void test(){
        System.out.println(myPow(2, 10));
    }
}
