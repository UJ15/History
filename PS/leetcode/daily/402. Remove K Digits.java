class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < num.length() ; i++) {
            String next = String.valueOf(num.charAt(i));

            while (k > 0 && !stack.isEmpty() && Integer.parseInt(stack.peek()) > Integer.parseInt(next)) {
                stack.pop();
                k--;
            }

            stack.push(next);
        }

        while (k-- > 0) {
            stack.pop();
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}