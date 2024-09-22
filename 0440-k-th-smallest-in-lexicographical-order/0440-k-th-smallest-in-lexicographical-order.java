class Solution {
    public int findKthNumber(int n, int k) {
        long num = 1;
        for (int i = 1; i < k; ) {
            int req = helper(num, num + 1, n);
            if (i + req <= k) {
                i += req;
                num++;
            } else {
                i++;
                num *= 10;
            }
        }

        return (int) num;
    }

    private int helper(long a, long b, long n) {
        int gap = 0;
        while (a <= n) {
            gap += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }

        return gap;
    }
}