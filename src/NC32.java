/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/6
 */
public class NC32 {

    public int sqrt(int x) {
        int i = 1;
        while (i * i <= x) {
            i++;
        }
        if (i * i == x) {
            return i;
        } else {
            return i - 1;
        }
    }
}
