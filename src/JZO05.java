import java.util.Arrays;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/12
 */
public class JZO05 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了63.83% 的用户
     * 将原字符数组扩充到需要的长度,然后从原数组最后一个元素的下标位置开始从后往前遍历新数组,把遍历的元素逐个添加到新数组尾.
     * 如果当前元素是需要被替换的字符,则将替换为的字符添加到新数组尾
     * @param s
     * @return
     */
    public String replaceSpace(String s) {

        String to = "%20";

        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                count++;
            }
        }

        char[] newChars = Arrays.copyOf(chars, count * (to.length()-1) + s.length());

        int p = newChars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (newChars[i] != ' ') {
                newChars[p] = newChars[i];
                p--;
            } else {
                newChars[p--] = '0';
                newChars[p--] = '2';
                newChars[p--] = '%';
            }
        }
        return new String(newChars);
    }

    @Test
    public void test(){
        System.out.println(replaceSpace("We are happy."));
    }
}
