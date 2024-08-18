class Solution {
    public int nthUglyNumber(int n) {
        int[] primes = new int[]{2, 3, 5};
        PriorityQueue <Long> uglyNumbers = new PriorityQueue<Long>();
        HashSet <Long> visited = new HashSet <Long> ();

        uglyNumbers.add(1L);
        visited.add(1L);

        long current = 1L;
        for (int i = 0; i < n; i++) {
            current = uglyNumbers.poll();
            for (int prime : primes) {
                long newUgly = current * prime;
                if (!visited.contains(newUgly)) {
                    uglyNumbers.add(newUgly);
                    visited.add(newUgly);
                }
            }
        } 
        return (int) current;
    }
}