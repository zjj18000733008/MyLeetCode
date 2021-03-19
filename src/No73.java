/**
 * @author JJ
 * @date 2020/8/24 - 21:52
 */
public class No73 {
    //执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：41.4 MB, 在所有 Java 提交中击败了35.93% 的用户
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] row=new int[m];
        int[] col=new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            if(row[i]==1){
                for(int j=0;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for (int j = 0; j < col.length; j++) {
            if (col[j] == 1) {
                for(int i=0;i<m;i++ ){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
