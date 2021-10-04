/**
 * @author JJ
 * @date 2020/7/16 - 15:09
 */
public class No13 {

    public static void main(String[] args) {
        No13 no13 = new No13();
        System.out.println(no13.romanToInt("III"));
        System.out.println(no13.romanToInt("IV"));
        System.out.println(no13.romanToInt("IX"));
        System.out.println(no13.romanToInt("LVIII"));
        System.out.println(no13.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            //如果i是字符串中最后一个,那么后面就没有元素和下标为i的元素比较,这时直接加上s.charAt(i)即可
            if (i == s.length() - 1) {
                result += romanToInt(s.charAt(i));
                return result;
            }
            //如果当前字符后面还有字符,则需要和后面的字符比较大小,进而确定当前字符的正负
            if (romanToInt(s.charAt(i)) <romanToInt(s.charAt(i+1))) {
                result -= romanToInt(s.charAt(i));
            } else {
                result += romanToInt(s.charAt(i));
            }
        }
        return 0;
    }

    public int romanToInt(char c) {
        int n=0;
        switch (c) {
            case 'I':
                n = 1;
                break;
            case 'V':
                n = 5;
                break;
            case 'X':
                n=10;
                break;
            case 'L':
                n=50;
                break;
            case 'C':
                n=100;
                break;
            case 'D':
                n=500;
                break;
            case 'M':
                n=1000;
                break;
            default:
                break;
        }
        return n;
    }
}
