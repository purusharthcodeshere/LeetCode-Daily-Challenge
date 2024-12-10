class Solution {
    public int maximumLength(String s) {
        int N = s.length();
        int left = 1, right = N;

        if (!helper(s, N, left)) return -1;

        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (helper(s, N , mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private boolean helper(String s, int N, int x) {
        int[] count = new int[26];
        int p = 0;

        for (int i = 0; i < N; i++) {
            while (s.charAt(p) != s.charAt(i)) p++;
            if (i - p + 1 >= x) count[s.charAt(i) - 'a']++;
            if (count[s.charAt(i) - 'a'] > 2) return true;
        }

        return false;
    }
}