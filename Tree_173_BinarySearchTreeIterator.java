/*
 *Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 *Calling next() will return the next smallest number in the BST.
 *
 *Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Tree_173_BinarySearchTreeIterator {  //In real program the class name should be BSTIterator
	
    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    private Stack<TreeNode> stack=new Stack<TreeNode>();
    private void pushLeft(TreeNode node){
    		if(node!=null){
    				stack.push(node);
    				TreeNode cur=node;
    				while(cur.left!=null){
    						stack.push(cur.left);
    						cur=cur.left;
    				}
    		}
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top=stack.peek();
        s.pop();
        pushLeft(top.right);
        return top.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */