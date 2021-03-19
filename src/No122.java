/**
 * @author JJ
 * @date 2020/7/29 - 10:50
 */
public class No122 {
    public int maxProfit(int[] prices) {
        //只要能赚钱,就卖出,就是最大能赚到的钱数
        int profits=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profits+=prices[i]-prices[i-1];
            }
        }
        return profits;
    }
}
