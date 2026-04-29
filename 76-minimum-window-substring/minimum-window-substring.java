class Solution {
    boolean valid(Map<Character,Integer>source,Map<Character,Integer>target){
        for(char c:target.keySet()){
            int count1=target.get(c);
            int count2=source.getOrDefault(c,0);
            //System.out.println("C:"+c+" C1: "+count1+" C2: "+count2);
            if(count1>count2)
                return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(m<n)
            return "";
        Map<Character,Integer>targetMap=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=t.charAt(i);
            int count=targetMap.getOrDefault(c,0);
            targetMap.put(c,count+1);
        }
        int[]res=new int[2];
        int minLen=m+1;
        int left=0,right=0;
        Map<Character,Integer>sourceMap=new HashMap<>();
        // for(char c:targetMap.keySet()){
        //     System.out.println(c+" : "+targetMap.get(c));
        // }
        while(right<m){
            char c=s.charAt(right);
           //System.out.println("c:"+c);
            if(targetMap.getOrDefault(c,0)!=0){
                sourceMap.put(c,sourceMap.getOrDefault(c,0)+1);
                //  for(char c1:sourceMap.keySet()){
                //     System.out.println(c1+" : "+sourceMap.get(c1));
                //     }
            }
            //System.out.println("Check: "+s.substring(left,right+1));
            while(valid(sourceMap,targetMap)){
                int len=right-left+1;
                //System.out.println("Check Pass: "+s.substring(left,right+1));
                minLen=Math.min(minLen,len);
                if(minLen==len){
                    res[0]=left;
                    res[1]=right;
                }
                char cl=s.charAt(left);
                if(targetMap.containsKey(cl))
                    sourceMap.put(cl,sourceMap.get(cl)-1);
                left++;
            }
            right++;
        }
        return minLen<=m?s.substring(res[0],res[1]+1):"";
    }
}