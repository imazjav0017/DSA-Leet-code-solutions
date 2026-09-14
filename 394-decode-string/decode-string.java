class Solution {
    public String decodeString(String s) {
        Deque<Integer>numStack=new ArrayDeque<>();
        Deque<StringBuilder>strStack=new ArrayDeque<>();
        StringBuilder curr=new StringBuilder();
        int num=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            else if(c=='['){
                numStack.push(num);
                strStack.push(curr);
                num=0;
                curr=new StringBuilder();
            }
            else if(c==']'){
                int repeat=numStack.pop();
                StringBuilder prev=strStack.pop();
                for(int i=0;i<repeat;i++){
                    prev.append(curr);
                }
                curr=prev;
            }
            else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}