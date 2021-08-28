import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Codec {
    /**
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
     * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     * <p>
     * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
     * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
     * <p>
     * Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
     * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
     */

    // Encodes a tree to a single string.
    private static final String NULL_STRING = "null";

    private static final String DELIMITER = " ";

    public String serialize(TreeNode root) {
        if (root == null) {
            return NULL_STRING;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(DELIMITER);
            if (Objects.isNull(node.left)) {
                sb.append(NULL_STRING);
            } else {
                sb.append(node.left.val);
            }
            queue.offer(node.left);
            sb.append(DELIMITER);
            if (Objects.isNull(node.right)) {
                sb.append(NULL_STRING);
            } else {
                sb.append(node.right.val);
            }
            queue.offer(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nums = data.split(DELIMITER);
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        for (String num : nums) {
            if (NULL_STRING.equals(NULL_STRING)) {

            }
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

