class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] undefeated = new boolean[n];
        Arrays.fill(undefeated, true);

        for (int[] edge : edges) {
            int loser = edge[1];
            undefeated[loser] = false;
        }

        int champion = -1;
        int championCount = 0;

        for (int team = 0; team < n; team++) {
            if (undefeated[team]) {
                champion = team;
                championCount++;
            }
        }

        return championCount == 1 ? champion : -1;
    }
}