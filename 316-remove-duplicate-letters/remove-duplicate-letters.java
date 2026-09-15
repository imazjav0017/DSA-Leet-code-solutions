class Solution {
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        int[]last=new int[26];
        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a']=i;
        }
        boolean[]instack=new boolean[26];
        Deque<Character>stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(instack[c-'a'])
                continue;
            while(!stack.isEmpty() && c<stack.peek() && last[stack.peek()-'a']>i){
                char removed=stack.pop();
                instack[removed-'a']=false;
            }
                stack.push(c);
                instack[c-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}