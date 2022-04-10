class Solution {
    List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return res;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;

        // 表示当前层没有初始化
        if (depth == res.size()) {
            res.add(new LinkedList<>());
        }
        // 获取当前层已有的数据
        List<Integer> lk = res.get(depth);
        lk.add(root.val);

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

}
