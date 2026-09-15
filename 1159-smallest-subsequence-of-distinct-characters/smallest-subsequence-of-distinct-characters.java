class Solution {
    public String smallestSubsequence(String s) {
        int n=s.length();
        int[]last=new int[26];
        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a']=i;
        }
        boolean[]inStack=new boolean[26];
        Deque<Character>stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(inStack[c-'a'])
                continue;
            while(!stack.isEmpty() && c<stack.peek() && last[stack.peek()-'a']>i){
                char removed=stack.pop();
                inStack[removed-'a']=false;
            }
            stack.push(c);
            inStack[c-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}