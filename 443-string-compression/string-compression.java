class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int r=1,w=0;
        char cc=chars[0];
        int count=1;
        while(r<=n){
            if(r==n||chars[r]!=cc){
                System.out.println(r+" :"+w+": "+cc);
                chars[w]=cc;
                w++;
                if(count>1){
                String s=String.valueOf(count);
                for(int i=0;i<s.length();i++){
                    chars[w]=s.charAt(i);
                    w++;
                }
                }
                if(r!=n){
                    cc=chars[r];
                    count=1;
                }
            }
            else{
                count++;
            }
            r++;
        }
        return w;
    }
}