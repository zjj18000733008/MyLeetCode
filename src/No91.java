import java.util.stream.IntStream;

/**
 * @author JJ
 * @date 2020/9/2 - 20:15
 */
public class No91 {
    //执行用时：2 ms, 在所有 Java 提交中击败了42.88% 的用户
    //内存消耗：38.4 MB, 在所有 Java 提交中击败了13.98% 的用户
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        if(s.indexOf('0')==0)return 0;
        if (len == 1){
            if(s.charAt(0)=='0')return 0;
            else return 1;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if(s.charAt(1)=='0'){
            Integer integer = Integer.valueOf(s.substring(0, 2));
            if(integer>=1 && integer<=26){
                dp[1]=1;
            }else{
                return 0;
            }
        }else{
            Integer integer = Integer.valueOf(s.substring(0, 2));
            dp[1] = 1 + (integer >= 0 && integer <= 26 ? 1: 0);
        }
        for (int i = 2; i < len; i++) {
            if(s.charAt(i)=='0'){
                Integer sub = Integer.valueOf(s.substring(i - 1, i + 1));
                if(sub>=1 && sub<=26){
                    dp[i]=dp[i-2];
                }else{
                    return 0;
                }
            }else {
                if(s.charAt(i-1)=='0'){
                    dp[i]=dp[i-1];
                    continue;
                }
                Integer sub = Integer.valueOf(s.substring(i - 1, i + 1));
                dp[i] = sub >= 1 && sub <= 26 ? dp[i - 1] + dp[i - 2] : dp[i - 1];
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
//        String str="226";
//        No91 no = new No91();
//        int i = no.numDecodings(str);
//        System.out.println(i);
        System.out.println(Integer.valueOf("01"));
    }
}
