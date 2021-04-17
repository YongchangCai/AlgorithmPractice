import java.util.Objects;

public class SubTreeOfAnotherTree {
    /**
     * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values
     * with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
     * The tree s could also be considered as a subtree of itself.
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (Objects.isNull(s)) {
            return false;
        } else if (s.val == t.val && isSameTree(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (Objects.isNull(s) && Objects.isNull(t)) {
            return true;
        } else if (Objects.nonNull(s) && Objects.nonNull(t) && s.val == t.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, s.right);
        } else {
            return false;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
