import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2020/7/28 - 20:49
 */
public class No118 {

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    list.add(1);
                }else{
                    List<Integer> l = lists.get(i - 1);
                    list.add(l.get(j)+l.get(j-1));
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        No118 no = new No118();
        List<List<Integer>> generate = no.generate(5);
    }
}
