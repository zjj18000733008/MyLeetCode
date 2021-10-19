/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/19
 */
public class JZO20 {

    public boolean isNumber(String s){
        String trimStr = s.trim();
        int i=0;
        if (trimStr.charAt(0) == '+' || trimStr.charAt(0) == '-') {
            i++;
        }
        return false;
    }

    public boolean isDecimals(String s){

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '+' || s.charAt(i) == '-') {
                continue;
            }

        }
        return true;
    }

    public boolean isInteger(String s){
        if (s.length() == 1) {
            return isNum(s.charAt(0));
        }

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '+' || s.charAt(i) == '-') {
                continue;
            }
            if (!isNum(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isNum(char c){
        return c>'0' && c<'9';
    }

}
