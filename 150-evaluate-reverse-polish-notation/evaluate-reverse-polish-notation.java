class Solution {
    boolean isNumber(String s){
       if(s.equals("+") || s.equals("-")||s.equals("*")||s.equals("/"))
            return false;
        return true;
    }
    public int evalRPN(String[] tokens) {
        int res=0;
        Deque<Integer>stack=new ArrayDeque<>();
        for(String s: tokens){
            if(isNumber(s)){
                stack.push(Integer.parseInt(s));
            }else{
                int b=stack.pop();
                int a=stack.pop();
                switch(s){
                    case "+":
                        res=a+b;
                        break;
                    case "-":
                        res=a-b;
                        break;
                    case "*":
                        res=a*b;
                        break;
                    case "/":
                        res=a/b;
                }
                stack.push(res);
            }
        }
        return stack.peek();
    }
}