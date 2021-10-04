/**
 * @author JJ
 * @date 2020/7/29 - 10:08
 */
public class No121 {

    public int maxProfit(int[] prices){
        if(prices.length==0) return 0;
        int maxProfit=0;//存储当天之前的最大利润
        int minPrice=prices[0];//存储当天之前的最小价格
        //从第二天开始遍历
        for (int i = 1; i < prices.length; i++) {
            //如果当天的价格比最小价格大,
            //则计算出当天卖出的利润,并与之前的最大利润比较,更新最大利润
            if(prices[i]>minPrice){
                int profit=prices[i]-minPrice;
                maxProfit=Math.max(profit,maxProfit);
            }else{
                //如果当天的价格比最小价格小
                //更新最小价格
                minPrice=prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        No121 no = new No121();
        int[] arr={7,1,5,3,6,4};
        int i = no.maxProfit(arr);
        System.out.println(i);
    }
}
