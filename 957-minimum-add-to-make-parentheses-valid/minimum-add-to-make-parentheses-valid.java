class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character>stack=new ArrayDeque<>();
        int count=0;
        for(char c: s.toCharArray()){
            if(c=='(')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    count++;
                else{
                    stack.pop();
                }
            }
        }
        return count+stack.size();
    }
}