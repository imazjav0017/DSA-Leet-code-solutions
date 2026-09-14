class Solution {
    public String simplifyPath(String path) {
        String[]arr=path.split("/");
        Deque<String>stack=new ArrayDeque<>();
        StringBuilder res=new StringBuilder();
        for(String s: arr){
            if(s.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else if(!s.equals("") &&!s.equals(".")){
                stack.push(s);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        while(!stack.isEmpty()){
            res.append("/");
            res.append(stack.removeLast());
        }
        return res.toString();
    }
}