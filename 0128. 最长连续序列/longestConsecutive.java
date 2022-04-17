class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        Arrays.sort(nums);

        int longMax = 1;
        int j;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] - nums[i-1] < 2){
                // 记录开始节点
                j = i-1;
                // 遍历连续节点
                while(i < nums.length && (nums[i] - nums[i-1] < 2) ){
                    i++;
                }
                // 当前连续数量 (nums[i-1] - nums[j] + 1)
                longMax = Math.max(longMax, (nums[i-1] - nums[j] + 1));     
            }
        }

        return longMax;
    }
        
}
