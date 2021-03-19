/**
 * 最长公共前缀
 * @author JJ
 * @date 2020/7/16 - 15:47
 */
public class No14 {

    public static void main(String[] args) {
        No14 no = new No14();

        System.out.println(no.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(no.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public String longestCommonPrefix(String[] strs){
        String base="";
        //遍历字符串数组
        for(int i=0;i<strs.length;i++){
            if(i==0){//默认先把首元素设为基准
                base=strs[0];
                continue;
            }
            int index;
            int minLength=Integer.min(base.length(),strs[i].length());
            //将当前字符串和base比较
            for(index=0;index<minLength;index++){
                //逐个字符进行比较,发现不同的字符则跳出循环
                if(base.charAt(index)!=strs[i].charAt(index)){
                    break;
                }
            }
            //确定index的值
            //截取和更新base,从0到index
            base=base.substring(0,index);
            //如果中途发现base已经是空字符串了,那么也就没有必要和后面的字符串进行比较了
            if(base==""){
                return "";
            }
        }
        return base;
    }
}
