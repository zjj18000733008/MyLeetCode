/**
 * @author JJ
 * @date 2020/8/22 - 21:25
 */
public class No48 {

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：40.1 MB, 在所有 Java 提交中击败了15.80% 的用户
    public void rotate(int[][] matrix) {

    //先上下翻转,再对角翻转
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                swap(matrix,i,j,n-i-1,j);
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                swap(matrix,i,j,j,i);
            }
        }
    }

    private void swap(int[][] matrix,int i1,int j1,int i2,int j2){
        int t=matrix[i1][j1];
        matrix[i1][j1]=matrix[i2][j2];
        matrix[i2][j2]=t;
    }

    public static void main(String[] args) {
        No48 no = new No48();
        int[][] arr={
                {5,1,9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        no.rotate(arr);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
