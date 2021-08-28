import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length, k);
        return Arrays.copyOf(points, k);
    }

    private int quickSelect(int[][] points, int left, int right, int target) {
        int pivit = sortPartition(points, left, right);
        if (pivit == target) {
            return pivit;
        }
        if (pivit > target) {
            return quickSelect(points, left, pivit -1, target);
        }
        if (pivit < target) {
            return quickSelect(points, pivit +1, right, target);
        }
        return -1;
    }

    private int sortPartition(int[][] points, int left, int right) {
        int[] partition = points[right];
        int pivit = left;
        for (int i = left; i < right; i++) {
            if (compare(points[i], partition) < 0) {
                swap(points, pivit, i);
                pivit++;
            }
        }
        swap(points, right, pivit);
        return pivit;
    }

    private void swap(int[][] points, int a, int b) {
        int[] c = points[a];
        points[a] = points[b];
        points[b] = c;
    }

    private int compare(int[] o1, int[] o2) {
        return (o1[0]*o1[0] + o1[1]*o1[1]) - (o2[0]*o2[0] + o2[1]*o2[1]);
    }

    private class PointComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return (o1[0]*o1[0] + o1[1]*o1[1]) - (o2[0]*o2[0] + o2[1]*o2[1]);
        }
    }
}
