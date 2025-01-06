class Solution {
    public int[] minOperations(String boxes) {
        int N = boxes.length();
        int[] result = new int[N];
        
        int ballsLeft = 0, movesLeft = 0;
        int ballsRight = 0, movesRight = 0;

        //Single pass: Calculate moves from both left and right
        for (int i = 0; i < N; i++) {
            //Left pass
            result[i] += movesLeft;
            ballsLeft += Character.getNumericValue(boxes.charAt(i));
            movesLeft += ballsLeft;

            //Right pass
            int j = N - 1 - i;
            result[j] += movesRight;
            ballsRight += Character.getNumericValue(boxes.charAt(j));
            movesRight += ballsRight;
        }

        return result;
    }
}