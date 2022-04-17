class Solution {
    public int maxProfit(int[] prices) {

        int reward = 0;// 最大回报
        int len = prices.length;

        for(int i = 1; i < len; ++i){
            // 计算递增大小和
            if(prices[i] > prices[i-1]){
                reward = reward + prices[i] - prices[i-1];
            }
        }

        return reward;
    }
}
