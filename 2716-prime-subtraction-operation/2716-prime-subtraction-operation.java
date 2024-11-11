class Solution {
    public boolean primeSubOperation(int[] nums) {
        int N = nums.length;
        //Get the maxElement
        int maxElement = Integer.MIN_VALUE;

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        //Create Sieve of Erastosthenes array tp identify prime numbers
        boolean[] seive = new boolean[maxElement + 1];
        Arrays.fill(seive, true);

        seive[0] = seive[1] = false;

        for (int i = 2; i <= Math.sqrt(maxElement + 1); i++) {
            if (seive[i]) {
                for (int j = i * i; j <= maxElement; j += i) {
                    seive[j] = false;
                }
            }
        }

        //Check if an array can be made strictly increasing by subtracting prime numbers
        int currentValue = 1;
        int i = 0;
        while (i < N) {
            int difference = nums[i] - currentValue;

            //Return false if current number is already smaller than required value
            if (difference < 0) {
                return false;
            }

            //Move to next number if difference is prime or zero
            if (seive[difference] == true || difference == 0) {
                i++;
                currentValue++;
            } else {
                currentValue++;
            }
        }

        return true;
    }
}