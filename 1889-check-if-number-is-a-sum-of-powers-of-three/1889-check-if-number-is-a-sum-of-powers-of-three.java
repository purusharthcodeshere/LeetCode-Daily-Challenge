class Solution {
    public boolean checkPowersOfThree(int n) {
        int power = 0;

        //Find the largest power that is smaller or equal to n
        while (Math.pow(3, power) <= n) {
            power++;
        }

        while (n > 0) {
            //Subtract the current power from n
            if (n >= Math.pow(3, power)) {
                n -= (int) Math.pow(3, power);
            }

            //We cannot use the same power twice
            if (n >= Math.pow(3, power)) {
                return false;
            }

            //Move to the next lower power
            power--;
        }

        //N has reached 0
        return true;
    }
}