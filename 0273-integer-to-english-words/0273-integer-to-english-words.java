class Solution {
    private final String[] words1 = {
        "",         "One",      "Two",          "Three",        "Four",
        "Five",     "Six",      "Seven",        "Eight",        "Nine",
        "Ten",      "Eleven",   "Twelve",       "Thirteen",     "Fourteen",
        "Fifteen",  "Sixteen",  "Seventeen",    "Eighteen",     "Nineteen"
    };

    private final String[] words2 = {
        "",         "Ten",      "Twenty",       "Thirty",       "Forty",
        "Fifty",    "Sixty",    "Seventy",      "Eighty",       "Ninety"
    };

    private final String[] words3 = {
        "",         "Thousand", "Million",      "Billion"
    };

    private String toEnglish(int num) {
        StringBuilder ans = new StringBuilder();

        if (num >= 100) {
            int q = num / 100;
            int r = num % 100;
            ans.append(words1[q]).append(" Hundred ");
            num = r;
        }

        if (num >= 20) {
            int q = num / 10;
            int r = num % 10;
            ans.append(words2[q]);
            if (r > 0) {
                ans.append(" ").append(words1[r]);
            }
        } else if (num > 0) {
            ans.append(words1[num]);
        }

        //Trim trailing space
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == ' ') {
            ans.setLength(ans.length() - 1);
        }

        return ans.toString();
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder ans = new StringBuilder();
        int count = 0;

        while (num > 0) {
            int r = num % 1000;
            num /= 1000;

            if (r > 0) {
                String part = toEnglish(r) + " " + words3[count];
                if (ans.length() > 0) {
                    ans.insert(0, part + " ");
                } else {
                    ans.insert(0, part);
                }
            }

            count++;
        }

        //Trim trailing space
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == ' ') {
            ans.setLength(ans.length() - 1);
        }

        return ans.toString();
    }
}