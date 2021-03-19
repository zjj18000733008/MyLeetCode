/**
 * @author JJ
 * @date 2020/8/8 - 16:40
 */
public class No5 {

//    执行用时：138 ms, 在所有 Java 提交中击败了28.37% 的用户 O(n3)
//    内存消耗：37.9 MB, 在所有 Java 提交中击败了92.53% 的用户 O(1)
    //1.暴力破解
    public String longestPalindrome1(String s) {
        int len=s.length();
        if(len<2){
            return s;
        }
        char[] str = s.toCharArray();//charAt()每次都会判断是否越界
        int begin=0;
        int maxlen=1;

        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(j-i+1>maxlen && isPalindromic(str,i,j)){
                    maxlen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
    //判断是否是回文串
    public boolean isPalindromic(char[] charArray ,int left ,int right){

        while(left<right){
            if(charArray[left++] != charArray[right--]) return false;
        }
        return true;
    }

    //2.中心扩展算法
    //执行用时：11 ms, 在所有 Java 提交中击败了93.96% 的用户 O(n2)
    //内存消耗：38.1 MB, 在所有 Java 提交中击败了80.91% 的用户 O(1)
    public String longestPalindrome2(String s){
        int len=s.length();
        if(len<2){
            return s;
        }
        int maxLen=0;
        int begin=0;
        char[] arr = s.toCharArray();
        for(int i=0;i<len-1;i++){
            int oddLen=expandAroundCenter2(arr,i,i);
            int evenLen=expandAroundCenter2(arr,i,i+1);
            int curLen=Math.max(oddLen,evenLen);
            if(curLen>maxLen){
                maxLen=curLen;
                begin=i-(maxLen-1)/2;
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    public int expandAroundCenter2(char[] arr,int left,int right){
        int len = arr.length;
        while(left>=0 && right<len){
            if(arr[left]==arr[right]){
                left--;
                right++;
            }else{
                break;
            }
        }
        return right-left-1;//回文串的长度是right-left+1-2=right-left-1
    }

    /**
     * 中心扩展算法第二次实现
     * 执行用时：37 ms, 在所有 Java 提交中击败了75.49% 的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了94.80% 的用户
     *
     * 算法思想:
     *  遍历字符串,每次以i或(i和i+1)为回文字符串的中心
     *  向两边扩展
     * @author JJ
     * @date 2021/3/18 19:47
     */
    public String longestPalindrome3(String s) {

        String ans="";
        int maxLen=0;
        int begin=0;

        if(s.length()<2){
            return s;
        }
//        if(s.length()==2){
//            return s.substring(0,1);
//        }

        for (int i = 0; i < s.length()-1; i++) {
            int x1=expandAroundCenter3(s,i,i);
            int x2=expandAroundCenter3(s,i,i+1);
            int curLen=Math.max(x1,x2);
            if(curLen>maxLen){
                maxLen=curLen;
                begin=i-(maxLen-1)/2;
            }
        }

        return s.substring(begin,begin+maxLen);
    }

    public int expandAroundCenter3(String s,int left,int right){

        while(left>=0 && right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }

        return right-left-1;
    }

    public static void main(String[] args) {
        String s="bb";
        No5 no5 = new No5();
        System.out.println(no5.longestPalindrome3(s));
    }

    //3.动态规划
    //状态: dp[i][j]表示子串s[i..j]是否为回文子串
    //状态转移方程: dp[i][j]=(s[i]==s[j] and dp[i+1][j-1]
    //边界条件: j-1-(i+1)+1<2 ,整理得j-i<3 即 j-i+1<4
//    public String longestPalidrome3(String s){
//        int len = s.length();
//        if(len<2){
//            return s;
//        }
//
//        char[] arr = s.toCharArray();
//
//    }
}
