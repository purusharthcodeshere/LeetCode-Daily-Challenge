class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < expression.length(); i++) {
            char operator = expression.charAt(i);
            if (operator == '+' || operator == '-' || operator == '*') {
                List<Integer> s1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> s2 = diffWaysToCompute(expression.substring(i + 1));
                for (int a : s1) {
                    for (int b : s2) {
                        if (operator == '+') {
                            result.add(a + b);
                        } else if (operator == '-') {
                            result.add(a - b);
                        } else if (operator == '*') {
                            result.add(a * b);
                        }
                    }
                }
            }
        }
        
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
}