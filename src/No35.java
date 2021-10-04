/**
 * 搜索插入位置
 * @author JJ
 * @date 2020/7/18 - 22:19
 */
public class No35 {

    public static void main(String[] args) {
        No35 no = new No35();
        System.out.println(no.searchInsert(new int[]{1,3,5,6},2));
    }

    //此方法简单,但不是最优解,当target比数组中所有元素都大时,需要遍历整个数组,当问题规模很大时需要耗费很长时间
//    public int searchInsert(int[] nums,int target){
//
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]>=target){
//                return i;
//            }
//        }
//        return nums.length;
//    }

    //二分查找
    //二分查找简单,但是需要注意细节
    public int searchInsert(int[] nums,int target){

        int i=0,j=nums.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]>=target){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i;

    }
}
