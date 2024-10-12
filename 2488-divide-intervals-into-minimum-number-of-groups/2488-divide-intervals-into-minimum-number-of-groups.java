class Solution {
    public int minGroups(int[][] intervals) {
        int N = intervals.length;
        int[] startTimes = new int[N];
        int[] endTimes = new int[N];

        //Extract start and end times
        for (int i = 0; i < N; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        //Sort start and end times
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int endIndex = 0, groupCount = 0;

        for (int start : startTimes) {
            if (start > endTimes[endIndex]) {
                endIndex++;
            } else {
                groupCount++;
            }
        }

        return groupCount;
    }
}