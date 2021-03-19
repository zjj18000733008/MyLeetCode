/**
 * @author JJ
 * @date 2020/7/30 - 14:33
 */
public class No167 {
    //213ms 7%
//    public int[] twoSum(int[] numbers, int target) {
//        int[] arr=new int[2];
//        for(int i=0;i<numbers.length-1;i++){
//            for(int j=i+1;j<numbers.length;j++){
//                if(numbers[i]+numbers[j]==target){
//                    arr[0]=i+1;
//                    arr[1]=j+1;
//                    return arr;
//                }
//            }
//        }
//        return null;
//    }

    //1ms 96.40%
    //双指针
    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        int[] arr=new int[2];
        while(left<right){
            if(numbers[left]+numbers[right]==target){
                arr[0]=left+1;
                arr[1]=right+1;
                return arr;
            }else if(numbers[left]+numbers[right]>target){
                right--;
            }else if(numbers[left]+numbers[right]<target){
                left++;
            }
        }
        return null;
    }
}
