/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/6
 */
public class NC44 {
    public boolean isMatch(String s, String p) {

        int i=0;
        int j=0;

        while (i<s.length() && j<p.length()) {
            char sChar = s.charAt(i);
            char pChar = p.charAt(j);
            if (pChar == '*') {

            } else if (pChar == '?' || sChar == pChar) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        // todo
        return false;
    }
}
