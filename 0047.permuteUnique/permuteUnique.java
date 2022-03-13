class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        int len = nums.length;
        backtrack(res, nums, new ArrayList<Integer>(), vis, len);
        return res;
    }
    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, boolean[] vis, int len) {
        if (tmp.size() == len) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            vis[i] = true;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, vis, len);
            vis[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
