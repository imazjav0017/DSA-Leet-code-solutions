class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int i=0;
        int insertAt=0;
        while(i<n){
            chars[insertAt]=chars[i];
            insertAt++;
            int j=i+1;
            while(j<n && chars[j]==chars[i]) {
                j++;
            }
            if(j-i>1){
                int num=j-i;
                int count=0;
                int length=j-i;
                while(num>0){
                 num/=10;
                 count++;
                }
                for(int k=0;k<count;k++){
                    chars[insertAt]=Integer.toString(length).charAt(k);
                    insertAt++;
                }
                
            }
            i=j;
        }
        //System.out.println(Arrays.toString(chars));
        return insertAt;
    }
}