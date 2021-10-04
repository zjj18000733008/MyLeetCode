import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/15
 */
public class No214 {

    /**
     *
     * 执行用时：478 ms, 在所有 Java 提交中击败了7.31% 的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了80.45% 的用户
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {

        /*
        从插入方向另一边遍历,采用中心扩散法找最长回文子串(子串不能被其他数包围)
         */
        int max = 1;
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 奇
            max = Math.max(centreExpand(str, i, i), max);

            // 偶
            max = Math.max(centreExpand(str, i, i + 1), max);
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i =max; i < s.length(); i++) {
            sb.insert(0, s.charAt(i));
        }

        return sb.toString();
    }

    /**
     * @param s
     * @param left
     * @param right
     * @return 回文串的长度
     */
    public int centreExpand(char[] s, int left, int right) {

        int len = s.length;
        if (left < 0 || right >= len) {
            return 0;
        }

        if (s[left] != s[right]) {
            return 0;
        }
        int count = right - left + 1;
        left--;
        right++;
        while (left >= 0 && right <= len - 1) {
            if (s[left] != s[right]) {
                return 0;
            } else {
                left--;
                right++;
                count += 2;
            }
        }
        if (left < 0) {
            return count;
        } else {
            return 0;
        }
    }

    //-----------------     ----------------

    public String shortestPalindrome2(String s) {



        return null;
    }



    @Test
    public void test() {
        Assert.assertEquals("ababbabbbababbbabbaba",shortestPalindrome("ababbbabbaba"));
        Assert.assertEquals("bbabb",shortestPalindrome("abb"));
        Assert.assertEquals("aaacecaaa", shortestPalindrome("aacecaaa"));
        Assert.assertEquals("dcbabcd", shortestPalindrome("abcd"));
    }
}
