class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int N = A.length;
        int[] freq = new int[N + 1];
        int[] result = new int[N];

        int count = 0;
        for (int i = 0; i < N; i++) {
            freq[A[i]]++;
            if (freq[A[i]] % 2 == 0) {
                count++;
            }
            freq[B[i]]++;
            if (freq[B[i]] % 2 == 0) {
                count++;
            }

            result[i] = count;
        }

        return result;
    }
}