import java.util.HashMap;
import java.util.Objects;

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        return copyRandomListDp(head, new HashMap<>());
    }

    public Node copyRandomListDp(Node head, HashMap<Node, Node> nodeMap) {
        if (Objects.isNull(head)) {
            return null;
        } else {
            Node newNode = new Node(head.val);

            nodeMap.put(head, newNode);

            if (Objects.nonNull(head.next) && nodeMap.containsKey(head.next)) {
                newNode.next = nodeMap.get(head.next);
            } else {
                newNode.next = copyRandomListDp(head.next, nodeMap);
            }

            if (Objects.nonNull(head.random) && nodeMap.containsKey(head.random.val)) {
                newNode.random = nodeMap.get(head.random);
            } else {
                newNode.random = copyRandomListDp(head.random, nodeMap);
            }

            return newNode;
        }
    }
}
