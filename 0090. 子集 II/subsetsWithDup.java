class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
   
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        //嵌套调用 // k 当前添加的数据个数
        for(int k = 0; k <= len; ++k){
            sub(0, len, k, nums);
            
        }
        return result;
    }

    public void sub(int left, int right, int k, int[] nums){
        //判断数量够的情况
        if(k == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        //遍历//剪枝
        for(int i = left; i <= right - k; ++i){
            list.add(nums[i]);
            //嵌套调用遍历
            sub(i+1, right, k-1, nums);
            //删除最后一个数据
            list.remove(list.size() - 1);
            while(i < right - k && nums[i+1] == nums[i]){
                i++;
            }
        }
    }
}
