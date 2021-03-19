/**
 * 移除元素 26,27有异曲同工之妙
 * @author JJ
 * @date 2020/7/16 - 18:48
 */
public class No27 {

    public static void main(String[] args) {
        No27 no = new No27();
        System.out.println(no.removeElement(new int[]{3,2,2,3},3));
        System.out.println(no.removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

    public int removeElement(int[] nums,int val){
        int lastValidIndex=-1;
        for(int i=0;i<nums.length;i++){
            if (nums[i] != val) {
                nums[lastValidIndex+1]=nums[i];
                lastValidIndex++;
            }
        }
        return lastValidIndex+1;
    }
}
