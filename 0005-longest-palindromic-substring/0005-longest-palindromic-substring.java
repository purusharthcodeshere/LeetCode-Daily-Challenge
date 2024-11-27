class Solution {
    public String longestPalindrome(String s) {
        //Single letter is the longest substring
        if (s.length() <= 0) return s;

        int N = s.length();

        int maxLength = 1;
        int start = 0, end = 0;

        //Check for odd length
        for (int i = 0; i < N - 1; i++) {
            int left = i, right = i;

            while (left >= 0 && right < N) {
                if (s.charAt(left) == s.charAt(right)) {
                    left -= 1;
                    right += 1;
                } else {
                    break;
                }
            }

            int length = right - left - 1;
            if (length > maxLength) {
                maxLength = length;
                start = left + 1;
                end = right - 1;
            }
        }

        //Check for even length
        for (int i = 0; i < N; i++) {
            int left = i, right = i + 1;
            
            while (left >= 0 && right < N) {
                if (s.charAt(left) == s.charAt(right)) {
                    left -= 1;
                    right += 1;
                } else {
                    break;
                }
            }

            int length = right - left - 1;
            if (length > maxLength) {
                maxLength = length;
                start = left + 1;
                end = right - 1;
            }
        }

        return s.substring(start, end + 1);
    }
}