class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> digit = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return digit;
        Arrays.sort(nums);
        int n = nums.length - 1;
        if((long) nums[0] + nums[1] + nums[2] + nums[3] > target || (long) nums[n-3] + nums[n] + nums[n - 1] + nums[n - 2] < target ) return digit;
        int left, right, fourSum;
        for(int i = 0; i < n-2; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) nums[i] + nums[n] + nums[n - 1] + nums[n - 2] < target) continue;
            for(int j = n; j > i+2; j--){
                if(j != n && nums[j] == nums[j+1]) continue;
                if((long) nums[j] + nums[j - 1] + nums[j - 2] + nums[j - 3] < target) break;
                if((long) nums[i] + nums[j] + nums[i + 2] + nums[i + 1] > target) continue;
                left = i+1;
                right = j-1;
                while(left < right){
                    fourSum = nums[i] + nums[left] + nums[right] + nums[j]; 
                    while(left < right && fourSum != target){
                        fourSum = fourSum < target? left++ : right--;
                        fourSum = nums[i] + nums[left] + nums[right] + nums[j]; 
                    }
                    if(left >= right)break;  
                    digit.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--; 
                    left++;
                }
            }
        }
        return digit;
    }
}
