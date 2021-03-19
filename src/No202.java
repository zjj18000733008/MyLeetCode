/**
 * @author JJ
 * @date 2020/7/31 - 16:37
 */
public class No202 {

    public boolean isHappy(int n) {
        /**
         * 不是快乐数的数称为不快乐数（unhappy number），所有不快乐数的数位平方和计算，
         * 最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中。
         */
        if(n==1)return true;
        if(n==4)return false;
        int sum=0;
        while(n!=0){
            sum+=(n%10)*(n%10);
            n/=10;
        }
        return isHappy(sum);
    }

    public static void main(String[] args) {
        No202 no = new No202();
        boolean happy = no.isHappy(19);
        System.out.println(happy);
    }
}
