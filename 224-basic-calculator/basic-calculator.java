class Solution {
    public int calculate(String s) {
        return eval(s.replaceAll(" ", ""), new int[]{0});
    }

    private int eval(String s, int[] idx) {
        int num = 0, result = 0, sign = 1;

        while (idx[0] < s.length()) {
            char c = s.charAt(idx[0]);

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
                idx[0]++; 
                num = eval(s, idx);
            } 
            else if (c == ')') {
                result += sign * num;
                return result;
            }

            idx[0]++;
        }

        result += sign * num;
        return result;
    }
}
