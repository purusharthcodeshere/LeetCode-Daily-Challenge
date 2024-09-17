class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        //Concatenate both the sentences with a space in between
        String s = s1 + " " + s2;
        //Create a HashMap to store the word counts
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        //Split the combined string into words
        String[] words = s.split(" ");
        //Count the occurences of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        //Create a list to store the uncommon words
        List<String> result = new ArrayList<String>();
        
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        return result.toArray(new String[0]);
    }
}