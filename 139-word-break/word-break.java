class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Set<String>dict=new HashSet<>();
        for(String w:wordDict){
            dict.add(w);
        }
        //dp[i]=can substr [0,i) be segmented
        boolean[]dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && dict.contains(s.substring(j,i)))
                    {
                        dp[i]=true;
                        break;
                    }
            }
        }
        return dp[n];
    }
}