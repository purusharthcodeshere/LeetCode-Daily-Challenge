class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet <Character> set = new HashSet <Character> ();
        
        for (char c : allowed.toCharArray()) {
            set.add(c);
        } 

        int count = words.length;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    count--;
                    break;
                }
            }
        } 

        return count;       
    }
}