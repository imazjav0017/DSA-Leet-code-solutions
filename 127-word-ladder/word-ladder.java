class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        int n=wordList.size();
        int m=wordList.get(0).length();
        Map<String,List<String>>graph=new HashMap<>();
        Map<String,Boolean> visited=new HashMap<>();
        wordList.add(beginWord);
        for(String word:wordList){
            for(int i=0;i<m;i++){
                char[]patt=word.toCharArray();
                patt[i]='*';
                String ptnStr=new String(patt);
                List<String>matches=graph.getOrDefault(ptnStr,new ArrayList<>());
                matches.add(word);
                graph.put(ptnStr,matches);
            }
            visited.put(word,false);
        }
        Queue<String>q=new ArrayDeque<>();
        q.offer(beginWord);
        visited.put(beginWord,true);
        int res=1;
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                String word=q.poll();
                if(word.equals(endWord))
                    return res;
                for(int j=0;j<m;j++){
                    char[]patt=word.toCharArray();
                    patt[j]='*';
                    List<String>matches=graph.get(new String(patt));
                    for(String next:matches){
                        if(!visited.get(next)){
                            q.offer(next);
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