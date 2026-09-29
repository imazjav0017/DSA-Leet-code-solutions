class Solution {
    public boolean isValid(String s) {
       Deque<Character>stack=new ArrayDeque<>();
       for(char c:s.toCharArray()){
        if(c=='(' || c=='{' || c=='[')
            stack.push(c);
        else if(stack.isEmpty())
            return false;
        else{
            boolean matched=false;
            switch(c){
                case ')':
                    matched=stack.peek()=='(';
                    break;
                case '}':
                    matched=stack.peek()=='{';
                    break;
                case ']':
                    matched=stack.peek()=='[';
                    break;
            }
            if(!matched)
                return false;
            stack.pop();
        }
       }
       return stack.isEmpty();
    }
}