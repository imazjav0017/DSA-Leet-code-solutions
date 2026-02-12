class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        wordList.add(beginWord);
        int n=wordList.size();
        int m=wordList.get(0).length();
        Map<String,List<String>>nei=new HashMap<>();
        Map<String,Boolean>visited=new HashMap<>();
        for(String word: wordList){
            for(int j=0;j<m;j++){
                char[] patt=word.toCharArray();
                patt[j]='*';
                String pattern=new String(patt);
                List<String>matches=nei.getOrDefault(pattern,new ArrayList<String>());
                matches.add(word);
                nei.put(pattern,matches);
            }
            visited.put(word,false);
        }
        Queue<String>queue=new ArrayDeque<>();
        visited.put(beginWord,true);
        queue.offer(beginWord);
        int res=1;
        while(!queue.isEmpty()){
            int s=queue.size();
            for(int i=0;i<s;i++){
                String x=queue.poll();
                if(x.equals(endWord)){
                    return res;
                }
                for(int j=0;j<m;j++){
                    char[]patt=x.toCharArray();
                    patt[j]='*';
                    String pattern=new String(patt);
                    for(String next:nei.get(pattern)){
                        if(!visited.get(next)){
                            queue.offer(next);
                            visited.put(next,true);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}