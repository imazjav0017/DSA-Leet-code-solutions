class Solution {
    public String reverseWords(String s) {
        // approach 1
        // String[] words = s.split(" +");
        // StringBuilder str = new StringBuilder();
        // for(int i = words.length-1; i >= 0; i--){
        //     str.append(words[i]);
        //     str.append(" ");
        // }
        // return str.toString().trim();

        // approach 2
        // String st = s.trim();
        // String[] str = st.split("\\s+");
        // int i = 0;
        // int j = str.length - 1;
        // while(i < j){
        //     String temp = str[i];
        //     str[i] = str[j];
        //     str[j] = temp;
        //     i++;
        //     j--;
        // }
        // return String.join(" ", str);

        // Approach 3
        //here s = "  hello world   "
        int left = 0;
        int right = s.length() - 1;
        while(left < s.length()){
            if(s.charAt(left) == ' '){
                left++;
            }
            else break;
        }

        while(right >= 0){
            if(s.charAt(right) == ' '){
                right--;
            }
            else break;
        }

        StringBuilder sb =  new StringBuilder();

        while(left <= right){
            if(s.charAt(left) != ' '){
                sb.append(s.charAt(left));
                left++;
            }
            else if(s.charAt(left) == ' '){
                if(sb.charAt(sb.length()-1) != ' '){
                    sb.append(' ');
                    left++;
                }
                else{
                    left++;
                }
            }
        }
        // here sb = "hello world"
        // now reverse
        int i =0,
        j = sb.length() - 1;
        while(i<j){
            char temp = sb.charAt(i);
            sb.setCharAt(i , sb.charAt(j));
            sb.setCharAt(j,temp);
            i++;
            j--;
        }
        //here sb = "dlrow olleh"
        // new reverse each word
        int start = 0,
            end = 0;

        while(start < sb.length()){
            while(end < sb.length() && sb.charAt(end) != ' '){
                end++;
            }
            int p1 = start,
                p2 = end - 1;
            
            while(p1 < p2){
                char temp = sb.charAt(p1);
                sb.setCharAt(p1 , sb.charAt(p2));
                sb.setCharAt(p2, temp);
                p1++;
                p2--;
            }
            start = end +1;
            end = start;
        }
        return sb.toString(); // finally it return "world hello"
    }
}