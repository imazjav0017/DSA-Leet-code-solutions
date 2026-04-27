class Solution {
    int getNextValidIndex(String s, int index){
        int backspaceCounter=0;
        while(index>=0){
            if(s.charAt(index)=='#'){
                backspaceCounter++;
            }
            else if(backspaceCounter==0){
                return index;
            }
            else{
                backspaceCounter--;
            }
            index--;
        }
        return index;
    }
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1;
        int j=t.length()-1;
        while(i>=0 || j>=0){
            i=getNextValidIndex(s,i);
            j=getNextValidIndex(t,j);
            if(i<0 && j<0){
                return true;
            }
            else if(i<0 || j<0){
                return false;
            }
            else if(s.charAt(i)!=t.charAt(j)){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}