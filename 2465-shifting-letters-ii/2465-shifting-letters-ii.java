class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int N = s.length();
        int[] count = new int[N];

        int Q = shifts.length;
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) {
                count[start]++;
                if (end < N - 1) {
                    count[end + 1]--;
                }
            } else {
                count[start]--;;
                if (end < N - 1) {
                    count[end + 1]++;
                }
            }
        }

        // for (int i = 1; i < N; i++) {
        //     count[i] += count[i - 1];
        // }

        StringBuilder result = new StringBuilder(s);
        int numberOfShifts = 0;

        // Apply the shifts to the string
        for (int i = 0; i < N; i++) {
            numberOfShifts = (numberOfShifts + count[i]) % 26; 
            // Update cumulative shifts, keeping within the alphabet range
            if (numberOfShifts < 0) numberOfShifts += 26; // Ensure non-negative shifts

            // Calculate the new character by shifting `s[i]`
            char shiftedChar = (char) ('a' +
                ((s.charAt(i) - 'a' + numberOfShifts) % 26));
            result.setCharAt(i, shiftedChar);
        }

        return result.toString();
    }
}