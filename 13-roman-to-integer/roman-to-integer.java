class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer>map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        HashMap<String,Integer>valid=new HashMap<>();
        valid.put("IV",4);
        valid.put("IX",9);
        valid.put("XL",40);
        valid.put("XC",90);
        valid.put("CD",400);
        valid.put("CM",900);
        int n=s.length();
        if(n==1)return map.get(s.charAt(0));
        int sum=0;
        for(int i=0;i<n-1;i++){
            char c1=s.charAt(i);
            char c2=s.charAt(i+1);
            char[]a={c1,c2};
            String v=new String(a);
            if(map.get(c1)>=map.get(c2)){
                sum+=map.get(c1);
            }
            else if(valid.containsKey(v))
            {
                sum+=valid.get(v);
                i+=1;
            }
            else sum+=map.get(c1);
            if(i==n-2)sum+=map.get(s.charAt(n-1));
        }
        return sum;
    }
}