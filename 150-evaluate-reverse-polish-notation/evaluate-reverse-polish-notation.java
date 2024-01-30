class Solution {
    
    static Set<String> operations = new HashSet<>(Arrays.asList("+","-","*","/"));
    
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token: tokens) {
            if(isOperation(token)) {
                int a = stack.pop();
                int b = stack.pop();
                int res = evaluate(b,a,token);
                stack.push(res);
            }
            else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

        private static int evaluate(int a, int b, String token) {
        switch (token) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default:
                return 0;
        }
    }

    private static boolean isOperation(String token) {
        return operations.contains(token);
    }
}