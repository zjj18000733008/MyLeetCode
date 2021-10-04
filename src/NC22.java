/**
 * @author JJ
 * @date 2021/3/22 - 16:43
 */
public class NC22 {
    /**
     * 运行时间：64ms
     * 超过60.88%用Java提交的代码
     * 占用内存：11484KB
     * 超过27.24%用Java提交的代码
     * @author JJ
     * @date 2021/3/22 16:44
     */
    public void merge(int A[], int m, int B[], int n) {
        int[] ans=new int[m+n];
        int i=0,j=0;
        int count=0;

        while(i<m && j<n){
            int min=0;
            if(A[i]<=B[j]){
                min=A[i++];
            }else{
                min=B[j++];
            }
            ans[count++]=min;
        }

        if(i<m){
            for(int x=i;x<m;x++){
                ans[count++]=A[x];
            }
        }
        if(j<n){
            for(int x=j;x<n;x++){
                ans[count++]=B[x];
            }
        }
        count=0;
        for(int a:ans){
            A[count++]=a;
        }
    }
}
