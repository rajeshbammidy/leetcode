class Solution {

    boolean isOperator(String token) {
        return token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/");
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        Stack<String> opeators = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int a;
                int b;
                switch (token) {
                    case "+":
                        a = operands.pop();
                        b = operands.pop();
                        operands.push(a + b);
                        break;
                    case "-":
                        b = operands.pop();
                        a = operands.pop();
                        operands.push(a - b);
                        break;
                    case "*":
                        b = operands.pop();
                        a = operands.pop();
                        operands.push(a * b);
                        break;
                    case "/":
                        b = operands.pop();
                        a = operands.pop();
                        operands.push(a / b);
                }
            } else {
                operands.push(Integer.parseInt(token));
            }
        }
        return operands.pop();
    }
}
