class Solution {
    public int findMinDifference(List<String> timePoints) {
        int N = timePoints.size();
        int[] minutes = new int[N];

        for (int i = 0; i < N; i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;
        }

        //Sort times in ascending order
        Arrays.sort(minutes);

        //Find minimum difference across adjacent elements
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++) {
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }

        //Consider the answer between last and first element
        return Math.min(ans, 24 * 60 - minutes[minutes.length - 1] + minutes[0]);
    }
}