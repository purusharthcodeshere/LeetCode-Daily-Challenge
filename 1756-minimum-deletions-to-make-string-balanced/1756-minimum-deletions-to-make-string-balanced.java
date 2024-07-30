class Solution {
    public int minimumDeletions(String s) {
        int N = s.length();
        int[] freq = new int[N + 1];
        int b = 0;

        for (int i = 1; i <= N; i++) {
            if (s.charAt(i - 1) == 'b') {
                freq[i] = freq[i - 1];
                b++;
            } else {
                freq[i] = Math.min(freq[i - 1] + 1, b);
            }
        }

        return freq[N];
        
    }
}