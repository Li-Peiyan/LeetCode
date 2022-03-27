class Solution {
    public void sortColors(int[] nums) {
        int[] num = new int[3];//记录各个颜色个数
        for(int i:nums){//统计
            num[i]++;
        }
        int index = 0;//nums下标
        for(int i = 0; i < 3; ++i){//访问各个颜色数
            for(int j = 0; j < num[i]; ++j){//赋值
                nums[index] = i;
                ++index;
            }
        }
    }
}
