import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class ZigZagOrder {
    /**
     * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
     * (i.e., from left to right, then right to left for the next level and alternate between).
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (Objects.isNull(root) ) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<Integer> layer = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    layer.add(0, node.val);
                } else {
                    layer.add(node.val);
                }
                if (Objects.nonNull(node.left)) {
                    queue.add(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.add(node.right);
                }
            }
            result.add(layer);
            level++;
        }

        return result;
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
