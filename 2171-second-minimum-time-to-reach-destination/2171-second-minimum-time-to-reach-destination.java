class Solution {
    public int secondMinimum(int N, int[][] edges, int time, int change) {

        List <Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Deque <int[]> deque = new LinkedList <> ();
        int[] visitedNum = new int[N + 1];
        int[] timeArr = new int[N + 1];

        Arrays.fill(timeArr, -1);

        deque.offerLast(new int[] {1, 0});
        timeArr[0] = 0;

        while (deque.size() > 0) {
            int currentSize = deque.size();
            
            for (int i = 0; i < currentSize; i++) {
                int[] current = deque.pollFirst();

                int nextTime = 0;
                int currentLight = current[1] / change;
                
                if (currentLight % 2 == 0) {
                    nextTime = current[1] + time;
                } else {
                    nextTime = (currentLight + 1) * change + time;
                }

                for (int nextNode : graph[current[0]]) {
                    if (visitedNum[nextNode] < 2 && timeArr[nextNode] < nextTime) {
                        deque.offerLast(new int[] {nextNode, nextTime});
                        visitedNum[nextNode]++;
                        timeArr[nextNode] = nextTime;

                        if (nextNode == N && visitedNum[nextNode] == 2) {
                            return nextTime;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}