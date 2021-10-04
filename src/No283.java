/**
 * @author JJ
 * @date 2020/8/4 - 22:40
 */
public class No283 {

    public void moveZeroes(int[] nums) {
        int start=-1;
        int len=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(start==-1){
                    start=i;
                    len++;
                }else{
                    len++;
                }
            }else{
                if(start!=-1 && len>0){
                    nums[start++]=nums[i];
                }
            }
        }
        for(int i=nums.length-len;i<nums.length;i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        int[] arr={0,1,0,3,12};
        No283 no = new No283();
        no.moveZeroes(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
