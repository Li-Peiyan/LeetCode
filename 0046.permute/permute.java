class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        int n = nums.length;
        backtrack(res, nums, n, new ArrayList<Integer>(), vis);
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, int n, ArrayList<Integer> tmp, boolean[] vis) {
        if (tmp.size() == n) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (vis[i]){
                continue;
            } 
            vis[i] = true;
            tmp.add(nums[i]);
            backtrack(res, nums, n, tmp, vis);
            vis[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
