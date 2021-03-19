/**
 * @author JJ
 * @date 2020/7/30 - 9:52
 */
public class No136 {
    //1015ms
//    public int singleNumber(int[] nums) {
//        int t=0;
//        boolean flag=false;
//        for(int i=0;i<nums.length-1;i++){
//            for(int j=0;j<nums.length-i-1;j++){
//                if(nums[j]>nums[j+1]){
//                    flag=true;
//                    t=nums[j];
//                    nums[j]=nums[j+1];
//                    nums[j+1]=t;
//                }
//            }
//            if(!flag){
//                break;
//            }else{
//                flag=false;
//            }
//        }
//        for(int i=0;i<nums.length;i+=2){
//
//            if(i+1>=nums.length || nums[i]!=nums[i+1]){
//                return nums[i];
//            }
//        }
//        return 0;
//    }

    //4ms
//    public int singleNumber(int[] nums){
//        quickSort(nums,0,nums.length-1);
//        for(int i=0;i<nums.length;i+=2){
//            if(i+1>=nums.length || nums[i]!=nums[i+1]){
//                return nums[i];
//            }
//        }
//        return 0;
//    }
//    public static void quickSort(int[] arr,int left,int right){
//        //在递归调用时的退出条件!!!很重要,否则会报Stack Overflow异常
//        if(left>right){
//            return;
//        }
//        int base=arr[left];//把最左边的数设为基准
//        int i=left,j=right;//设置哨兵
//        int t;
//
//        while(i<j){
//            //因为把最左边的数设为基准,所以要先让右边的哨兵j先出动
//            while(arr[j]>=base && i<j){
//                j--;
//            }
//            //不写成arr[i]<base,因为arr[left]==base,导致while永远进不去
//            while(arr[i]<=base && i<j){
//                i++;
//            }
//            //交换两个哨兵所找到的值
//            if(i<j){
//                t=arr[i];
//                arr[i]=arr[j];
//                arr[j]=t;
//            }
//        }
//        //当i==j时,退出while循环
//        //这时只需将最左边的数(基准)和arr[i]交换即可
//        arr[left]=arr[i];
//        arr[i]=base;
//        //递归调用左半数组
//        quickSort(arr,left,i-1);
//        //递归调用右半数组
//        quickSort(arr,i+1,right);
//    }

    public int singleNumber(int[] nums) {
        /*
        交换律：a ^ b ^ c <=> a ^ c ^ b
        任何数于0异或为任何数 0 ^ n => n
        相同的数异或为0: n ^ n => 0
        var a = [2,3,2,4,4]
        2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
         */
        int r=0;
        for(int i=0;i<nums.length;i++){
            r^=nums[i];
        }
        return r;
    }

    public static void main(String[] args) {
        No136 no = new No136();
        int[] arr = {4, 1, 2, 1, 2};
//        int[] arr={2,2,1};
        int i = no.singleNumber(arr);
        System.out.println(i);
    }
}
