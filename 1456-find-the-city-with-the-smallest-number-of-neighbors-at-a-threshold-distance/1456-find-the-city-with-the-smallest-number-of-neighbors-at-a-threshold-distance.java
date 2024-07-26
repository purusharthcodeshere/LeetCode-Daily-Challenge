class Solution {
    public int findTheCity(int N, int[][] edges, int distanceThreshold) {

        int[][] distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            //Dont fill with Integer.MAX_VALUE
            //As it might overflow
            Arrays.fill(distance[i], 100_000_000);
            distance[i][i] = 0;
        }

        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int ans = -1;
        int mini = Integer.MAX_VALUE;
        int[] reachable = new int[N];

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            reachable[i] = count;
            if (count <= mini) {
                mini = count;
                ans = i;
            }
        }

        return ans;
        
    }
}