import sun.misc.JavaSecurityProtectionDomainAccess;

/**
 * @author JJ
 * @date 2020/8/19 - 18:26
 */
public class No31 {

//    public void nextPermutation(int[] nums) {
//        boolean flag=true;
//        for(int i=1;i<nums.length-1;i++){
//            int max=nums[i];
//            int k=i;
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[j]>max){
//                    k=j;
//                    max=nums[j];
//                }
//            }
//            if(max!=nums[i]){
//                int t=nums[i];
//                nums[i]=nums[k];
//                nums[k]=t;
//                flag=false;
//            }
//        }
//        if(flag){
//            int left=0,right=nums.length-1;
//            while(left<right){
//                int t=nums[left];
//                nums[left]=nums[right];
//                nums[right]=t;
//                left++;
//                right--;
//            }
//        }
//    }

    public void nextPermutation(int[] nums) {

    }

    public static void main(String[] args) {
        No31 no = new No31();
        int[] arr={3,2,1};
        no.nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
