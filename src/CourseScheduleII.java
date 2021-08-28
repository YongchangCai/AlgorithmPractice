import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
     * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
     * <p>
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return the ordering of courses you should take to finish all courses. If there are many valid answers,
     * return any of them. If it is impossible to finish all courses, return an empty array.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        int[] adjCount = new int[numCourses];
        Arrays.fill(adjCount, 0);
        initGraph(adjCount, graph, prerequisites);
        return bfsOrder(adjCount, graph, prerequisites);
    }

    private void initGraph(int[] adjCount, List<Integer>[] graph, int[][] prerequisites) {
        for (int[] requiste : prerequisites) {
            graph[requiste[1]].add(requiste[0]);
            adjCount[requiste[0]]++;
        }
    }

    private int[] bfsOrder(int[] adjCount, List<Integer>[] graph, int[][] prerequisites) {
        int classNum = adjCount.length;
        int[] result = new int[classNum];
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < classNum; i++) {
            if (adjCount[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int k = queue.poll();
            result[count++] = k;
            for (int j : graph[k]) {
                adjCount[j]--;
                if (adjCount[j] == 0) {
                    queue.add(j);
                }
            }
        }
        return count == classNum ? result : new int[0];
    }


}
