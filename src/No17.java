import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 回溯算法
 *
 * @author JJ
 * @date 2020/8/17 - 13:10
 */
public class No17 {
    List<String> list = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return list;
        }
        backtrack("", digits);
        return list;
    }

    private void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            list.add(combination);
        } else {
            char digit = next_digits.charAt(0);
            String alpha = map.get(digit);
            for (int i = 0; i < alpha.length(); i++) {
                String str=combination;
//                str+=alpha.charAt(i);//这一步会比下面那一步多花6ms
                str+=alpha.substring(i,i+1);
                backtrack(str,next_digits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        No17 no = new No17();
        List<String> list = no.letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
