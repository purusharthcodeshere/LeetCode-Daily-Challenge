class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Character.isDigit(c)) {
                stack.pop();
            } else if (Character.isLetter(c)) {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder("");
        stack.stream().forEach(c -> sb.append(c)); // iterates from bottom to top of stack
        
        return sb.toString(); 
    }
}