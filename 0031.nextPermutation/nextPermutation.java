class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2)return;

        int num, left = nums.length, right, n = left - 1;
        while(left > 1){
            --left;
            if(nums[left] > nums[left - 1]){
                for(int i = left; i <= n; i++){
                    num = nums[left - 1];
                    if(nums[i] <= num || i == n){ 
                        if(nums[i] <= num){
                            nums[left - 1] = nums[i - 1];
                            nums[i - 1] = num;
                        }else{
                            nums[left - 1] = nums[i];
                            nums[i] = num;
                        }
                        right = n;
                        while(left < right){
                            num = nums[left];
                            nums[left] = nums[right];
                            nums[right] = num;
                            left++; right--;
                        }
                        return;
                    }
                }
            }
        }
        left = 0;   right = n;
        while(left < right){
            num = nums[left];
            nums[left] = nums[right];
            nums[right] = num;
            left++; right--;
        }
    }
}
