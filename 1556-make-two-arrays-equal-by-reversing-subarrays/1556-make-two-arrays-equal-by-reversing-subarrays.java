class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {

        if (arr.length != target.length) {
            return false;
        }
        
        int N = arr.length;
        int max = Integer.MIN_VALUE;
        int[] freq = new int[1001];

        for (int i = 0; i < N; i++) {
            freq[target[i]]++;
            freq[arr[i]]--;
            max = Math.max(max, Math.max(target[i], arr[i]));
        } 

        for (int i = 1; i <= max; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;       
    }
}