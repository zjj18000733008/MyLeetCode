/**
 * @author JJ
 * @date 2020/8/24 - 22:30
 */
public class No75 {

//    public void sortColors(int[] nums) {
//        int left=0,right=nums.length-1;
//        while(left<right){
//            while(left<right && nums[left]!=1){
//                if(nums[left]==2){
//                    swap(nums,left,right);
//                    break;
//                }else{//0
//                    left++;
//                }
//            }
//
//            while(left<right && nums[right]!=1){
//                if(nums[right]==0){
//                    swap(nums,left,right);
//                    break;
//                }else{//2
//                    right--;
//                }
//            }
////            if(nums[left]==1 && nums[right]==1)break;
//        }
//    }

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：38.1 MB, 在所有 Java 提交中击败了78.22% 的用户
    public void sortColors(int[] nums){
        int left=0,right=nums.length-1;
        int cur=0;
        while(cur<=right) {
            if(nums[cur]==0){
                swap(nums,left,cur);
                left++;
                cur++;
            }else if(nums[cur]==2){
                swap(nums,cur,right);
                right--;

            }else{
                cur++;
            }

        }
    }

    private void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public static void main(String[] args) {
        No75 no = new No75();
//        int[] arr={2,0,2,1,1,2};
        int[] arr={2,0,1};
        no.sortColors(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
