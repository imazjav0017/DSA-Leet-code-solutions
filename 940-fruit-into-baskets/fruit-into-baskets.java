class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int left=0,right=0;
        int maxFruits=0;
        Map<Integer,Integer>map=new HashMap<>();
        while(right<n){
            int c=map.getOrDefault(fruits[right],0);
            map.put(fruits[right],c+1);
            while(left<=right && map.size()>2){
                int cl=map.getOrDefault(fruits[left],0)-1;
                if(cl<1){
                    map.remove(fruits[left]);
                }
                else{
                    map.put(fruits[left],cl);
                }
                left++;
            }
            int len=right-left+1;
            maxFruits=Math.max(len,maxFruits);
            right++;
        }
        return maxFruits;
    }
}