class Solution {
    boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) != -1;
    }
    public String reverseVowels(String s) {
        char[]arr=s.toCharArray();
        int n=arr.length;
        List<Integer>vowels=new ArrayList<>();
        for(int i=0;i<n;i++){
            char c=arr[i];
            if(isVowel(c))
                vowels.add(i);
        }
        if(vowels.size()<2){
            return s;
        }
        int r=vowels.size()-1;
        int l=0;
        while(l<r){
            int li=vowels.get(l),ri=vowels.get(r);
            char temp=arr[li];
            arr[li]=arr[ri];
            arr[ri]=temp;
            l++;
            r--;
        }
        return new String(arr);

    }
}