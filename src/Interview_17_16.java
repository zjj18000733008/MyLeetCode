/**
 * @author JJ
 * @date 2021/1/10 - 15:26
 */
public class Interview_17_16 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：35.5 MB, 在所有 Java 提交中击败了92.58% 的用户
     * @author JJ
     * @date 2021/1/10 15:52
     */
    public int massage(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int beforPre=nums[0];
        int pre=Math.max(beforPre,nums[1]);
        int temp=0;
        if(nums.length==2){
            return Math.max(beforPre,pre);
        }
        for (int i = 2; i < nums.length; i++) {
            temp=pre;
            pre=Math.max(pre,beforPre+nums[i]);
            beforPre=temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        Interview_17_16 no = new Interview_17_16();
        int[] arr = {2, 1, 4, 5, 3, 1, 1, 3};
        int massage = no.massage(arr);
        System.out.println(massage);
    }
}
