class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        while(sb.charAt(i)==' '){
            i++;
        }
        if(i>0){
            sb.delete(0,i);
        }
        int n=sb.length();
        i=n-1;
        while (sb.charAt(i)==' '){
            i--;
        }
        if(i<n-1){
            sb.delete(i+1,n);
        }
        n=sb.length();
        for(int j=0;j<n;j++){
            if(sb.charAt(j)==' '){
                int end=j+1;
                while(sb.charAt(end)==' ')end++;
                if(end!=j+1){
                    sb.delete(j+1,end);
                    n=sb.length();
                }
            }
        }
        n=sb.length();
        int left=0,right=n-1;
        while(left<right){
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
        for(int j=0;j<n;){
            int l=j,r=l;
            while(r<n && sb.charAt(r)!=' '){ r++;}
            r--;
            j=r;
            System.out.println(n+":"+l+":"+r);
            while(l<r){
                char temp = sb.charAt(l);
                sb.setCharAt(l, sb.charAt(r));
                sb.setCharAt(r, temp);
                l++;
                r--;
            }
            j+=2;
        }
        // System.out.println(sb.toString());
        return sb.toString();

    }
}