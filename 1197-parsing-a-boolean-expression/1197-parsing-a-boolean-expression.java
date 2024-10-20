class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<Character>();

        for (char current : expression.toCharArray()) {
            if (current == ',' || current == '(') {
                continue;
            }

            if (current == 't' ||
                current == 'f' ||
                current == '!' ||
                current == '&' ||
                current == '|') {
                    stack.push(current);
            } else if (current == ')') {
                boolean hasTrue = false, hasFalse = false;

                while (stack.peek() != '!' && stack.peek() != '&' && stack.peek() != '|') {
                    char top = stack.pop();
                    if (top == 't') hasTrue = true;
                    if (top == 'f') hasFalse = true;
                }

                char operator = stack.pop();
                if (operator == '!') {
                    stack.push(hasTrue ? 'f' : 't');
                } else if (operator == '&') {
                    stack.push(hasFalse ? 'f' : 't');
                } else {
                    stack.push(hasTrue ? 't' : 'f');
                }
            } 
        }

        return stack.peek() == 't';
    }
}