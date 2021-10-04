import java.util.jar.JarEntry;

/**
 * @author JJ
 * @date 2020/7/29 - 10:54
 */
public class No125 {

    /*
    分享个字母大小写转换的方法：

    统一转成大写：ch & 0b11011111 简写：ch & 0xDF
    统一转成小写：ch | 0b00100000 简写：ch | 0x20

比较的时候注意加上小括号哦，因为位运算优先级比较低。

使用示例：
if((s.charAt(i ++) & 0xDF) != (s.charAt(j --) & 0xDF)) return false;
     */
    public boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        int[] arr = new int[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
//            if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
//                arr[j] = s.charAt(i);
//                j++;
//            }
            if ((s.charAt(i)>='0' && s.charAt(i)<='9') || (s.charAt(i)>='a' &&s.charAt(i)<='z') || (s.charAt(i)>='A' &&s.charAt(i)<='Z')) {
                arr[j] = s.charAt(i);
                j++;
            }

        }
        int k = 0, l = j - 1;
        while (k < l) {
            if ((arr[k++] & 0xDF) != (arr[l--] & 0xDF)) return false;//同一转换成大写进行比较
        }
        return true;
    }

    public static void main(String[] args) {
        No125 no = new No125();
//        boolean palindrome = no.isPalindrome("A man, a plan, a canal: Panama");
        boolean palindrome = no.isPalindrome("0P");
//        boolean palindrome = no.isPalindrome("aadxef");
//        boolean palindrome = no.isPalindrome("");
//        boolean palindrome = no.isPalindrome("race a car");
        System.out.println(palindrome);
    }
}
