/**
 * @author JJ
 * @date 2020/7/31 - 9:40
 */
public class No189 {

    public void rotate(int[] nums, int k) {
//        if(nums.length==0)return;
//        int t=nums[0];
//        int j=0;
//        if(nums.length%k!=0){
//            for(int i=0;i<nums.length;i++){
//                int temp=nums[(j+k)%nums.length];
//                nums[(j+k)%nums.length]=t;
//                t=temp;
//                j+=k;
//
//            }
//        }else{
//            for
//        }

    }

    public static void main(String[] args) {
//        int[] arr={1,2,3,4,5,6,7};
        int[] arr={-1,-100,3,99};
        No189 no189 = new No189();
        no189.rotate(arr,2);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
