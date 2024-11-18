class Solution {
    public int[] decrypt(int[] code, int k) {
        int N = code.length;
        int[] ans = new int[N];

        if (k == 0) {
            return ans;
        }

        int start = 0, end = 0;
        
        if (k > 0) {
            start = 1; 
            end = k;
        } else {
            start = N - Math.abs(k);
            end = N - 1;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += code[i];
        }

        for (int i = 0; i < N; i++) {
            ans[i] = sum;
            sum -= code[start % N];
            sum += code[(end + 1) % N];
            start++;
            end++;
        }

        return ans;
    }
}