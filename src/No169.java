/**
 * @author JJ
 * @date 2020/7/30 - 16:48
 */
public class No169 {

    //摩尔投票法,适合用于找到一堆无序数的众数,(前提条件:众数个数大于总数的1/2)
    public int majorityElement(int[] nums) {
        /**
         * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，
         * 减到0就重新换个数开始计数，总能找到最多的那个
         */
        if(nums.length==0) return 0;
        int count=1;
        int maj=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==maj){
                count++;
            }else{
                count--;
            }
            if(count==0){
                maj=nums[i];
                count++;
            }
        }
        return maj;
    }

    public static void main(String[] args) {
//        int[] arr={1,2,3,4,5};
        int[] arr={1,2,2,3,3,2};
        No169 no = new No169();
        int i = no.majorityElement(arr);
        System.out.println(i);
    }
}
