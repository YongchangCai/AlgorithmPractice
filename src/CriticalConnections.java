import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 */
public class CriticalConnections {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i=0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] rank = new int[n];
        Arrays.fill(rank,-2);
        HashSet<List<Integer>> result = new HashSet<>();
        dfs(0, result, graph, 0, rank);

        return new ArrayList<>(result);


    }

    private int dfs(int n, HashSet<List<Integer>> connections, List<Integer>[] graph, int depth, int[] rank) {
        if (rank[n] >= 0) {
            return rank[n];
        }
        rank[n] = depth;
        int minDepth = depth;
        for (int neighbor : graph[n]) {
            if (rank[neighbor] == depth -1) {
                continue;
            }
            int nextDepth = dfs(neighbor, connections, graph, depth + 1, rank);
            minDepth = Math.min(minDepth, nextDepth);
            if (nextDepth <= depth) {
                connections.remove(Arrays.asList(n, neighbor));
                connections.remove(Arrays.asList(neighbor, n));
            }
        }

        return minDepth;
    }
}
