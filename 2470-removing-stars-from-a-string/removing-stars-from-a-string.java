class Solution {
    public String removeStars(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c!='*'){
                st.push(c);
            }
            else{
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:st){
            sb.append(c);
        }
        return sb.toString();
    }
}