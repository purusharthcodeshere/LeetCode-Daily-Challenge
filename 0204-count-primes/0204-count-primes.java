class Solution {
    public int countPrimes(int n) {

        if (n < 3) {
            return 0;
        }

        int count = 0;
        boolean[] primes = new boolean[n + 1];
        java.util.Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j+= i) {
                    primes[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }

        return count;
    }
}