class Solution {
    Node preNode = null, nextStart = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            preNode = null;

            nextStart = null;// 记录下一层第一个不为空的节点
            
            // 遍历当前层
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }

            // 下一层第一个不为空的节点开始遍历
            start = nextStart;
        }
        return root;
    }
    
    // 用于连接
    public void handle(Node p) {
        // 前驱节点不为空时，连接
        if (preNode != null) {
            preNode.next = p;
        } 
        // 记录下一层第一个不为空的节点
        if (nextStart == null) {
            nextStart = p;
        }
        preNode = p;
    }
}
