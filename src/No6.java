/**
 * @author JJ
 * @date 2020/8/10 - 19:11
 */
public class No6 {
    /**
     * 0   4   8    12
     * 1 3 5 7 9 11 13 15
     * 2   6   10   14
     *
     * 执行用时：3 ms, 在所有 Java 提交中击败了99.12% 的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了82.22% 的用户
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        int base = 2 * (numRows - 1);//我把第一行第二列的数视为基准,它的下标可以通过行数求得
        int top = base;//将基准赋值给top,待会while循环遍历要用到
        int len = s.length();
        int col = 1;//用于记录第一行有多少列
        int k = 2;
        while (top <= len - 1) {//求出第一行有多少列
            col++;
            top = base * k;
            k++;
        }
        //根据第一行的列数创建一位数组
        int[] bases = new int[col];
        //将第一行的字符的下标赋值给数组
        for (int i = 0; i < col; i++) {
            bases[i] = base * i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                if (bases[j] + i > len-1) {
                    break;
                } else {
                    sb.append(s.charAt(bases[j] + i));
                }
                //如果不是第一行或最后一行,那么有可能要计算斜边上的字符的下标
                if (i != 0 && i != numRows - 1) {
                    //斜边上字符的下标可以通过bases[j]计算得来
                    if (bases[j] +2*numRows-i-2> len-1) {
                        break;
                    } else {
                        sb.append(s.charAt(bases[j] +2*numRows-i-2));
                    }
                }

            }
        }
        return sb.toString();
    }

    /**
     * 
     * @author JJ
     * @date 2021/3/18 20:26
     */
    public String convert2(String s,int numRows){
        return "";
    }
    
    public static void main(String[] args) {
        No6 no = new No6();
//        String leetcodeishiring = no.convert("LEETCODEISHIRING", 3);
        String leetcodeishiring = no.convert("LEETCODEISHIRING", 2);
        System.out.println(leetcodeishiring);
    }
}
