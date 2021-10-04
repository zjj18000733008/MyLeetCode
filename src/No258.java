/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * @author JJ
 * @date 2020/8/4 - 16:32
 */
public class No258 {

    public int addDigits(int num) {
        if(num==0)return 0;
        int i = num % 9;
        if(i==0){
            return 9;
        }
        return i;
    }
}
