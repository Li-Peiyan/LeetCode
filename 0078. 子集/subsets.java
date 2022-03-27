class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        //嵌套调用
        for(int i = 0; i <= len; ++i){
            sub(0, len, i, nums, ansList, list);
        }
        return ansList;
    }

    public void sub(int left, int right, int k, int[] nums, List<List<Integer>> ansList, List<Integer> list){
        //判断数量够的情况
        if(k == 0){
            ansList.add(new ArrayList<Integer>(list));
            return;
        }
        //遍历//剪枝
        for(int i = left; i <= right - k; ++i){
            list.add(nums[i]);
            //嵌套调用遍历
            sub(i+1, right, k-1, nums, ansList, list);
            //删除最后一个数据
            list.remove(list.size() - 1);
        }
    }
}
