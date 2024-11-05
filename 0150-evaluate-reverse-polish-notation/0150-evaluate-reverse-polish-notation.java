class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        // int N = tokens.length;

        Stack<Integer> stack = new Stack();
        int ans = 0;

        for (String i : tokens) {
            if (checkOperator(i)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(evaluate(a, b, i.charAt(0)));
                // char operator = tokens[i].charAt()
            } else {
                stack.push(Integer.parseInt(i));
            }
        }

        return stack.peek();
    }

    private int evaluate(int a, int b, char operator) {
        if (operator == '+') {
            return a + b;
        } else if (operator == '-') {
            return a - b;
        } else if (operator == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    public boolean checkOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
}