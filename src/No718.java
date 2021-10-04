/**
 * @author JJ
 * @date 2021/1/11 - 13:17
 */
public class No718 {

    /**
     * 动态规划
     * 执行用时：57 ms, 在所有 Java 提交中击败了55.29% 的用户
     * 内存消耗：47.3 MB, 在所有 Java 提交中击败了44.11% 的用户
     * @author JJ
     * @date 2021/1/11 13:22
     */
    public int findLength(int[] A, int[] B) {

        int max=0;
        int m=A.length;
        int n=B.length;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(A[i]==B[j]){
                    dp[i][j]=((i-1<0 || j-1<0)?0:dp[i-1][j-1])+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }

        return max;
    }
    /**
     * 执行用时：72 ms, 在所有 Java 提交中击败了20.25% 的用户
     * 内存消耗：47.4 MB, 在所有 Java 提交中击败了30.76% 的用户
     * @author JJ
     * @date 2021/1/12 22:12
     */
    public int findLength_3(int[] A, int[] B) {
        int max=0;
        int m=A.length;
        int n=B.length;
        int[][] dp=new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(A[i-1]==B[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=0;
                max=Math.max(max,dp[i][j]);
            }
        }

        return max;
    }

    /**
     * 滑动窗口
     * 执行用时：52 ms, 在所有 Java 提交中击败了67.79% 的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了93.97% 的用户
     * @author JJ
     * @date 2021/1/12 16:17
     */
    public int findLength_2(int[] A,int[] B){
        //调整位置,让长的数组作为不动的,短的数组每次向右移一格
        if(A.length>=B.length){
            return findLength_2Helper(A,B);
        }else{
            return findLength_2Helper(B,A);
        }
    }

    public int findLength_2Helper(int[] A,int[] B){
        int aLength=A.length;
        int bLength=B.length;
        int total=aLength+bLength-1;//运行的总次数
        int aStart;
        int bStart;
        int max=0;

        //A不动,B每次向右滑一格
        for (int i = 0; i < total; i++) {
            int len=0;
            //确定窗口
            if(i<bLength){
                aStart=0;
                bStart=bLength-i-1;
                len=i+1;
            }else{
                aStart=i- B.length+1;
                bStart=0;
                len=Math.min(aLength-aStart,bLength);
            }
            int maxLen = maxLength(A, B, aStart, bStart, len);
            max=Math.max(max,maxLen);
            //对窗口内的A,B进行比较
        }
        return max;
    }

    /**
     * 计算窗口内的最大长度
     * @param A
     * @param B
     * @param aStart
     * @param bStart
     * @param len
     * @return
     */
    public int maxLength(int[] A,int[] B,int aStart,int bStart,int len){
        int max=0,count=0;
        for (int i = 0; i < len; i++) {
            if(A[aStart+i]==B[bStart+i]){
                count++;
                max=Math.max(max,count);//记录下最大长度
            }else{
                count=0;
            }
        }
        return max;
    }

}
