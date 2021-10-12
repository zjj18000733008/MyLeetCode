import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/12
 */
public class JZO87 {

    /**
     * time-consuming: 1h
     * 执行用时：7 ms, 在所有 Java 提交中击败了20.31% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了33.55% 的用户
     * 解析:
     * IP地址分为四段,
     * 定义从起始位置start到指针所在位置这段字符串为一段.
     * [ 1. 这一段长度不能超过3 2. 这一段字符串的大小要在0~255之间 3. 这一段字符串不能以0开头 4. 这一段的长度不能过长,至少要给后面每一段都留一个字符的长度]
     * 如果当前字符串不符合要求,则continue ;
     * 如果当前这一段字符串符合要求, 那么找下一段字符串 ( 递归 [ 更新起始位置start, 当前属于第几段pNum  ] )
     *      递归会返回一个可用的字符串集合, 只需将当前字符串与递归返回的字符串连接成新串,add to new set ,return
     * 如果现在处于第四段字符串, 第四段字符串属于剩余字符串, 直接判断第四段字符串是否符合要求,不符合要求就返回一个emptySet
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return new ArrayList<>();
        }

        return new ArrayList<>(backtrace(s, 1, 0));
    }

    public Set<String> backtrace(String s, int pNum, int start) {
        HashSet<String> set = new HashSet<>();
        if (pNum == 4) {
            String substring = s.substring(start);
            if (avilable(substring)) {
                set.add(substring);
            }
            return set;
        }

        for (int i = start; i < s.length() + pNum - 4 && i - start < 3; i++) {
            String substring = s.substring(start, i + 1);
            if (!avilable(substring)) {
                continue;
            }
//            StringBuilder sb = new StringBuilder();
//            sb.append(substring);

            Set<String> subResult = backtrace(s, pNum + 1, i + 1);
            if (subResult.size() == 0) {
                continue;
            }
            subResult.forEach(subStr -> {
//                set.add(sb.toString() + subStr);
                set.add(substring+"."+subStr);
            });
        }
        return set;
    }

    public boolean avilable(String substring) {
        if (substring.length() > 1 && substring.startsWith("0")) {
            return false;
        }
        Integer n1 = Integer.valueOf(substring);
        if (n1 > 255 || n1 < 0) {
            return false;
        }
        return true;
    }

    @Test
    public void test1(){
        restoreIpAddresses("25525511135").forEach(System.out::println);
        System.out.println("---");
        restoreIpAddresses("0000").forEach(System.out::println);
        System.out.println("---");
        restoreIpAddresses("1111").forEach(System.out::println);
        System.out.println("---");
        restoreIpAddresses("010010").forEach(System.out::println);
        System.out.println("---");
        restoreIpAddresses("10203040").forEach(System.out::println);
    }
}
