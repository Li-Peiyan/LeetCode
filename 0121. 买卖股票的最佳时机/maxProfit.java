class Solution {
    public int maxProfit(int[] prices) {
        int minIndex = prices[0];// 前些日子的最低股票值
        int maxReward = 0;// 目前最高回报
        
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] < minIndex){

                minIndex = prices[i];

            }else if(prices[i] - minIndex > maxReward){

                maxReward = prices[i] - minIndex;

            }
        }

        return maxReward;

    }
}
