/**
 * @author JJ
 * @date 2020/7/27 - 10:21
 */
public class No66 {

    public int[] plusOne(int[] digits) {



        for (int i = digits.length-1; i >=0; i--) {
            if(digits[i]==9){
                if(i==0){
                    int[] ints = new int[digits.length + 1];
                    ints[0]=1;
                    return ints;
                }
                digits[i]=0;
            }else{
                digits[i]+=1;
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
//        int[] arr={1,2,3};
//        int[] arr={9,9,9};
        int[] arr={4,3,2,1};
        No66 no = new No66();
        int[] plusOne = no.plusOne(arr);
        for (int i : plusOne) {
            System.out.println(i);
        }
    }
}
