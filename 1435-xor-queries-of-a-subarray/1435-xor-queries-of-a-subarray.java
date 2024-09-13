class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int N = arr.length;
        int[] prefix = new int[N];
        prefix[0] = arr[0];
        
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }

        int M = queries.length;
        int[] result = new int[M];

        for (int k = 0; k < M; k++) {
            int left = queries[k][0];
            int right = queries[k][1];
            if (left == 0) {
                result[k] = prefix[right];
            } else {
                result[k] = prefix[right] ^ prefix[left - 1];
            }
        }

        return result;
    }
}