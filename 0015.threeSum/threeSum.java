class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> digit = new ArrayList<List<Integer>>();
        if(nums.length < 3)return digit;
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[ nums.length - 1 ] <0)return digit;
        int left,right;
        for (int i = 0; i < nums.length - 2; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i+1;
            right = nums.length - 1;
            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                while(left < right && sum != 0)
                {
                    sum = sum < 0 ? left++ : right--;//暂存，无意义
                    sum = nums[i] + nums[left] + nums[right];
                }
                if(left >= right)break;  

                digit.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (right > left && nums[right] == nums[right - 1]) right--;
                while (right > left && nums[left] == nums[left + 1]) left++;
                right--; 
                left++;
            }
        }
        return digit;
    }
}
