class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer>stack=new ArrayDeque<>();
        char[]res=new char[s.length()];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            res[i]=c;
            if(c=='(')
                stack.push(i);
            else if(c==')'){
                if(!stack.isEmpty()) stack.pop();
                else res[i]='*';
            }
        }
        while(!stack.isEmpty()){
            res[stack.pop()]='*';
        }
        for(int i=0;i<s.length();i++){
            if(res[i]!='*')
                sb.append(res[i]);
        }
        return sb.toString();
    }
}