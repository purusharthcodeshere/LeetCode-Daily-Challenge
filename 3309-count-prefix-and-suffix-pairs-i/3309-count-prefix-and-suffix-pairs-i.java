class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int N = words.length;
        int count = 0;

        //Step 1: Iterate through each pair of words
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String word1 = words[i];
                String word2 = words[j];

                //Step 2: Skip if the first dtring is larger than the second
                if (word1.length() > word2.length()) {
                    continue;
                }

                //Step 3: Check if word1 and word2 is both the prefix and suffix of word2
                if (word2.startsWith(word1) && word2.endsWith(word1)) {
                    count++;
                }
            }
        }

        //Step 4: Return the total count of prefix-suffic pairs
        return count;
    }
}