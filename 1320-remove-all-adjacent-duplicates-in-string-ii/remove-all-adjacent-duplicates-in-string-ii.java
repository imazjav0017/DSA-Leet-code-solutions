class Solution {

    class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {

        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() &&
                stack.peek().ch == c) {

                stack.peek().count++;

            } else {

                stack.push(new Pair(c, 1));
            }

            if (stack.peek().count == k) {
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();

        for (Pair pair : stack) {
            result.append(
                String.valueOf(pair.ch).repeat(pair.count)
            );
        }

        return result.toString();
    }
}