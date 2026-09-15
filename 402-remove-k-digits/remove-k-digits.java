class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character>stack=new ArrayDeque<>();
        int i=0;
        while (i<=num.length()){
            char c=i==num.length()?'0':num.charAt(i);
            while(k>0 && !stack.isEmpty() && c<stack.peek()){
                stack.pop();
                k--;
            }
            if(i<num.length())
                stack.push(c);
            i++;
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty() && stack.peekLast()=='0')
            stack.removeLast();
        if(stack.isEmpty()) sb.append("0");
        while(!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}