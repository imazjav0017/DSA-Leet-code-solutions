class Solution {
    boolean isNumber(String s){
        return !(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }
    public int evalRPN(String[] tokens) {
      Deque<Integer>stack=new ArrayDeque<>();
      for(String s: tokens){
        if(isNumber(s)){
            stack.push(Integer.parseInt(s));
        }
        else{
            int b=stack.pop();
            int a=stack.pop();
            int res=0;
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
                break;
            }
            stack.push(res);
        }
      }
      return stack.pop();
    }
}