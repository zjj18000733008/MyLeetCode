import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2020/10/6 - 16:44
 */
public class No139 {
    /**
     *
     * 题意: 字符串拆分后的结果要全都能在wordDict中找到对应的单词;如果拆分后,某个单词在字典中找不到,则返回false
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n =s.length();
        boolean[] dp =new boolean[n+1];
        dp[0]=true;//前一个true的下标和后一个true的下标(不包含)组成的字符串包含在字典中
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        No139 no = new No139();
        String s="catsandog";
        ArrayList<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        boolean b = no.wordBreak(s, list);
    }
}
