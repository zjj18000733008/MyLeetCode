import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author JJ
 * @date 2020/8/13 - 12:34
 */
public class No12 {

    public static void main(String[] args) {
        No12 no = new No12();
        String s = no.intToRoman(20);
        System.out.println(s);
    }

    //执行用时：4 ms, 在所有 Java 提交中击败了99.99% 的用户
    //内存消耗：39.2 MB, 在所有 Java 提交中击败了90.60% 的用户
    public String intToRoman(int num) {

        int[] bases={1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder sb=new StringBuilder();
        int index=bases.length-1;
        while(num>0){

            for(int i=index;i>=0;i--){
                if(num>=bases[i]){
                    sb.append(getBasicRoman(bases[i]));
                    num-=bases[i];
                    break;
                }
            }
        }
        return sb.toString();
    }

    private String getBasicRoman(int num){
        switch (num){
            case 1:
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
            default:
                return "?";
        }
    }
}
