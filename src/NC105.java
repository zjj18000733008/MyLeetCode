/**
 * @author JJ
 * @date 2021/3/22 - 20:30
 */
public class NC105 {


    public int search (int[] nums, int target) {
//        return binarySearch(nums,0,nums.length-1,target);
        return binarySearch(nums,target);
    }

    /**
     * 运行时间：158ms
     * 超过9.70%用Java提交的代码
     * 占用内存：22148KB
     * 超过82.41%用Java提交的代码
     * @author JJ
     * @date 2021/3/22 20:51
     */
    public static int binarySearch(int[] arr,int value){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==value){
                int t=mid;
                while (t>=0 && arr[t]==value){
                    t--;
                }
                return t+1;
            }else if(arr[mid]>value){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
}
