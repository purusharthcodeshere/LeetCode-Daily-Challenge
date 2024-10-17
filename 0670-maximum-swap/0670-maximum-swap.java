class Solution {
    public int maximumSwap(int num) {
        //Convert number to string for digit manipulation
        char[] numArr = Integer.toString(num).toCharArray();
        int N = numArr.length;

        //Track last occurence of each digit (0-9)
        int[] last = new int[10];
        for (int i = 0; i< N; i++) {
            last[numArr[i] - '0'] = i;
        }

        //Traverse the number from left to right
        for (int i = 0; i < N; i++) {
            //Check if we can find a larger digit to swap
            for (int digit = 9; digit > numArr[i] - '0'; digit--) {
                if (last[digit] > i) {
                    //Swap and return the new number
                    char temp = numArr[i];
                    numArr[i] = numArr[last[digit]];
                    numArr[last[digit]] = temp;
                    return Integer.parseInt(new String(numArr));
                }
            }
        }

        //Return the original number if no swap occured
        return num;
    }
}