class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        int N = nums.length;
        long currentSum = 0;
        Deque<Pair<Long, Integer>> queue = new ArrayDeque<>();
        //Prefix_sum, End_index

        for (int r = 0; r < N; r++) {
            currentSum += nums[r];

            if (currentSum >= k) {
                result = Math.min(result, r + 1);
            }

            //Find the minimum valid window ending at r
            while (!queue.isEmpty() && currentSum - queue.peekFirst().getKey() >= k) {
                Pair<Long, Integer> front = queue.pollFirst();
                result = Math.min(result, r - front.getValue());
            }

            //Validate the monotonic deque
            while (!queue.isEmpty() && queue.peekLast().getKey() > currentSum) {
                queue.pollLast();
            }

            queue.offerLast(new Pair<>(currentSum, r));
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    //Helper clas to store pairs
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}