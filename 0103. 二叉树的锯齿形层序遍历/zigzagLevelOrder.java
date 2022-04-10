class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return res;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        // 当前层没有数据,初始化
        if (depth == res.size()) {
            res.add(new LinkedList<>());
        }
        // 获取当前层的数据集
        LinkedList<Integer> lk = (LinkedList<Integer>) res.get(depth);
        if (depth % 2 == 0) {
            lk.addLast(root.val);
        } else {
            lk.addFirst(root.val);
        }
        
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
