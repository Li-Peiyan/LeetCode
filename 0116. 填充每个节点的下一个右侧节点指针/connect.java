/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        // 从根节点开始
        Node leftNode = root;
        
        while (leftNode.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node node = leftNode;
            
            while(node != null){

                // 子节点连接
                node.left.next = node.right;

                if(node.next != null){
                    // 节点间的 子节点连接
                    node.right.next = node.next.left;
                }

                node = node.next;
            }
            // 下一层
            leftNode = leftNode.left;
        }
        
        return root;
    }
}
