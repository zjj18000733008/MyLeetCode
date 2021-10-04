/**
 * @author JJ
 * @date 2020/7/30 - 19:06
 */
public class No171 {

    public int titleToNumber(String s) {
        int sum=0;
        int p=1;
        for(int i=s.length()-1;i>=0;i--){
            sum+=(s.charAt(i)-'A'+1)*p;
            p*=26;
        }
        return sum;
    }

    public static void main(String[] args) {
        No171 no = new No171();
        int i = no.titleToNumber("Z");
        System.out.println(i);
    }
}
