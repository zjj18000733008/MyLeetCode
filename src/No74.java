/**
 * @author JJ
 * @date 2020/8/24 - 22:17
 */
public class No74 {

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：39.8 MB, 在所有 Java 提交中击败了11.20% 的用户
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)return false;
        if(matrix[0].length==0)return false;
        int m=matrix.length;
        int n=matrix[0].length;
        for (int i = 0; i < m; i++) {
            if(target<=matrix[i][n-1]){
                if(target<matrix[i][0]) return false;
                int left=0,right=n-1;
                while(left<=right){
                    int mid=(left+right)/2;
                    int midnum = matrix[i][mid];
                    if(midnum==target)return true;
                    else if(midnum<target){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
                break;
            }
        }
        return false;
    }
}
