class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> combine = new ArrayList<Integer>();
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return ans;
    }
    public void dfs(int[] candidates, int target, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 选择当前数
        for(int i = idx; i < candidates.length && target - candidates[i] >= 0;){
            combine.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            combine.remove(combine.size() - 1);
            n = candidates[i++];
            while(i < candidates.length && n == candidates[i])++i;
        }
    }
}
