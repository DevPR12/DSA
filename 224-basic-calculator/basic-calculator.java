class Solution {
    public int calculate(String s) {
        int n = s.length();
         int result = 0;
        int sign = 1;  
        int num = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } 
            else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } 
            else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } 
            else if (c == '(') {
         
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } 
            else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop(); 
                result += stack.pop(); 
            }
        }

        if (num != 0) {
            result += sign * num;
        
         } return result;
    }
}
