class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : banned) {
            seen.add(num);
        }

        int count = 0, sum = 0;

        for (int i = 1; i <= n; i++) {
            if (!seen.contains(i) && sum + i <= maxSum) {
                sum += i;
                count++;
            }
        }

        return count;
    }
}