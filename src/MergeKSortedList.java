import java.util.Objects;

public class MergeKSortedList {

    /**
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     * <p>
     * Merge all the linked-lists into one sorted linked-list and return it.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = null;

        if (Objects.isNull(lists) || lists.length == 0) {
            return null;
        } else {

            for (ListNode node : lists) {
                merge2List(result, node);
            }
        }


        return result;


    }

    private ListNode merge2List(ListNode list1, ListNode list2) {
        ListNode result;
        if (list1 == null) {
            result = list2;
        } else if (list2 == null) {
            result = list1;
        } else {
            if (list1.val < list2.val) {
                result = new ListNode(list1.val, merge2List(list1.next, list2));
            } else {
                result = new ListNode(list2.val, merge2List(list2.next, list1));
            }
        }
        return result;
    }
}
