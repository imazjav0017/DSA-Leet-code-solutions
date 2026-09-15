class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer>stack=new ArrayDeque<>();
        for(int i=0;i<asteroids.length;i++){
            int current=asteroids[i];
            boolean isAlive=true;
            while(isAlive && !stack.isEmpty() && stack.peek()>0 && current<0){
                if(stack.peek()<Math.abs(current)){
                    stack.pop();
                }
                else {
                    isAlive=false;
                    if(stack.peek()==Math.abs(current))
                        stack.pop();
                }
            }
            if(isAlive)
                stack.push(current);
        }
        int[]res=new int[stack.size()];
        int idx=0;
        while(!stack.isEmpty()){
            res[idx++]=stack.removeLast();
        }
        return res;
    }
}