public class Solution {

    public int countCompleteComponents(int n, int[][] edges) {
        // Create adjacency list representation of the graph
        List<Integer>[] graph = new ArrayList[n];
        for (int vertex = 0; vertex < n; vertex++) {
            graph[vertex] = new ArrayList<>();
        }

        // Build graph from edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        // Process each unvisited vertex
        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                // BFS to find all vertices in the current component
                List<Integer> component = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                queue.add(vertex);
                visited[vertex] = true;

                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    component.add(current);

                    // Process neighbors
                    for (int neighbor : graph[current]) {
                        if (!visited[neighbor]) {
                            queue.add(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }

                // Check if component is complete (all vertices have the right number of edges)
                boolean isComplete = true;
                for (int node : component) {
                    if (graph[node].size() != component.size() - 1) {
                        isComplete = false;
                        break;
                    }
                }

                if (isComplete) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }
}