class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer>stack=new ArrayDeque<>();
        int lastInvalid=-1;
        int max=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(')
                stack.push(i);
            else if(c==')'){
                if(!stack.isEmpty()){
                    int idx=stack.pop();
                    if(stack.isEmpty()){
                        max=Math.max(max,i-lastInvalid);
                    }else{
                        max=Math.max(max,i-stack.peek());
                    }
                }else{
                    lastInvalid=i;
                }
            }
        }
        return max;
    }
}