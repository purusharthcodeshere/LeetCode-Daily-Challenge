class Solution {
    public boolean isCircularSentence(String sentence) {
        //Get the length of the sentence
        int N = sentence.length();

        //First check: Compare first and last character of the sentence
        //For a circular sentence, they must match
        if (sentence.charAt(0) != sentence.charAt(N - 1)) {
            return false;
        }

        //Iterate through the sentence, starting from index 1 to N-2
        //We do not need to check those characters again
        for (int i = 1; i < N - 1; i++) {
            //When we find a space character
            if (sentence.charAt(i) == ' ') {
                //Check if the character before space matches the character after the space
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }

        //If we made through all the checks, sentence is circular
        return true;        
    }
}