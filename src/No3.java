import java.util.HashSet;

/**
 * @author JJ
 * @date 2020/8/8 - 15:50
 */
public class No3 {

    //滑动窗口
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();//用于判断是否有重复字符
        int n = s.length();
        int rkey = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {

            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            //只要不越界且字符不重复,右指针就一直右移
            while (rkey + 1 < n && !set.contains(s.charAt(rkey + 1))) {
                set.add(s.charAt(rkey + 1));
                rkey++;
            }
            ans = Math.max(ans, rkey - i + 1);
        }
        return ans;
    }

    /**
     * 执行用时：354 ms, 在所有 Java 提交中击败了5.01% 的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了31.09% 的用户
     * @author JJ
     * @date 2021/3/18 19:02
     */
    public int lengthOfLongestSubstring_2(String s) {
        Integer[] arr = new Integer[150];
        int len = s.length();
        int count = 0;
        int left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (arr[c] != null && arr[c] >= left) left = arr[c] +1;
            arr[c]=i;
            right++;

            System.out.print(s.substring(left, right) + " ");
            System.out.println();
            count = Math.max(right - left, count);
        }
        return count;
    }

    public static void main(String[] args) {
        No3 no = new No3();
//        int i = no.lengthOfLongestSubstring("pwwkew");
//        int i = no.lengthOfLongestSubstring_2("pwwkew");
        int i = no.lengthOfLongestSubstring_2("abcabcbb");
        System.out.println(i);
    }
}
