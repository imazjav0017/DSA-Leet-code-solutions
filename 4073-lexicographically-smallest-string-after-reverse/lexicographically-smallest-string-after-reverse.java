class Solution {
    public String lexSmallest(String s) {
        String smallest = "{";
        if(s.length() == 1) return s;
        char[] charArr = s.toCharArray();
        for(int i = 1; i < s.length(); i++){
            StringBuilder reversedFirstK = new StringBuilder();
            StringBuilder reversedLastK = new StringBuilder();
            StringBuilder totalString = new StringBuilder();
            for(int k = i; k >= 0; k--){
                reversedFirstK.append(s.charAt(k));
            }
            for(int k = s.length()-1; k >= s.length() - i; k--){
                reversedLastK.append(s.charAt(k));
            }
            totalString.append(reversedFirstK);
            totalString.append(s.substring(i+1,s.length()));
            // System.out.println(totalString);
            smallest = smallest.compareTo(totalString.toString()) > 0 ? totalString.toString() : smallest;
            totalString = new StringBuilder();
            totalString.append(s.substring(0, s.length() - i));
            totalString.append(reversedLastK);
            // System.out.println(totalString);
            // System.out.println("^^^^^^^^^");
            smallest = smallest.compareTo(totalString.toString()) > 0 ? totalString.toString() : smallest;
        }
        return smallest;
    }
}