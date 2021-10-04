/**
 * @author JJ
 * @date 2021/1/12 - 20:59
 */
public class No1143 {
    /**
     * 执行用时：14 ms, 在所有 Java 提交中击败了31.96% 的用户
     * 内存消耗：42.3 MB, 在所有 Java 提交中击败了42.97% 的用户
     * @author JJ
     * @date 2021/1/12 21:34
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp=new int[len1][len2];
        int max=0;

        for (int i = 0; i < len2; i++) {
            if(text1.charAt(0)==text2.charAt(i)){
                dp[0][i]=1;
            }else{
                dp[0][i]=(i==0?0:dp[0][i-1]);
            }
            max=Math.max(max,dp[0][i]);
        }
        for (int i = 0; i < len1; i++) {
            if(text2.charAt(0)==text1.charAt(i)){
                dp[i][0]=1;
            }else{
                dp[i][0]=(i==0?0:dp[i-1][0]);
            }
            max=Math.max(max,dp[i][0]);
        }


        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if(text2.charAt(j)==text1.charAt(i)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                max=Math.max(max,dp[i][j]);
            }
        }
//        for (int[] d : dp) {
//            for (int i : d) {
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }
        return max;
    }

    /**
     * 执行用时：14 ms, 在所有 Java 提交中击败了31.96% 的用户
     * 内存消耗：42.2 MB, 在所有 Java 提交中击败了48.30% 的用户
     * @author JJ
     * @date 2021/1/12 21:39
     */
    public int longestCommonSubsequence_2(String text1,String text2){
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp=new int[len1+1][len2+1];//把数组多加一行和一列,可以避免去判断边界条件
        int max=0;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(text2.charAt(j-1)==text1.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        //打印结果
        for (int[] d : dp) {
            for (int i : d) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        return max;
    }

    public static void main(String[] args) {
        String t1="abcde";
        String t2="ace";
        No1143 no = new No1143();
        no.longestCommonSubsequence_2(t2,t1);
    }
}
