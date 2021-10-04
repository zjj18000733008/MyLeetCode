/**
 * 回文数
 * @author JJ
 * @date 2020/7/16 - 14:52
 */
public class No9 {

    public static void main(String[] args) {
        No9 no9 = new No9();
        System.out.println(no9.isPalindrome(121));
    }

    public boolean isPalindrome(int x){
        String str=x+"";
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }

        return true;
    }
}
