import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/18
 */
public class JZO16 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.6 MB, 在所有 Java 提交中击败了37.20% 的用户
     *
     * return x^(n/2) * x^(n/2)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x,int n){

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if (n < 0) {
            if (n % 2 == 0) {
                double v = myPow(x, -(n / 2));
                return 1/ (v*v);
            }else{
                return 1/myPow(x, -n);
            }
        }

        if (n % 2 == 0) {
            double v = myPow(x, n / 2);
            return v*v;
        }else{
            return myPow(x, n-1)*x;
        }
    }

    @Test
    public void test(){
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2.0, -2));
        System.out.println(myPow(2,-2147483648));
    }

    @Test
    public void test2(){
        double v=1;
        System.out.println(1==v);
        int n=-2147483648;
        int n1=2147483647;

        System.out.println(-n);
        System.out.println(-n1);
    }
}
