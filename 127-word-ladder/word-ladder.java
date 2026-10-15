class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        if(!wordList.contains(beginWord))
            wordList.add(beginWord);
        Map<String,List<String>>map=new HashMap<>();
        for(String word:wordList){
            char[]arr=word.toCharArray();
            for(int i=0;i<arr.length;i++){
                char temp=arr[i];
                arr[i]='*';
                String s=new String(arr);
                List<String> list=map.getOrDefault(s,new ArrayList<>());
                list.add(word);
                map.put(s,list);
                arr[i]=temp;
            }
        }
        Queue<String>q=new ArrayDeque<>();
        q.offer(beginWord);
        int count=0;
        Set<String>visited=new HashSet<>();
        visited.add(beginWord);
        while(!q.isEmpty()){
           int n=q.size();
           count++;
           for(int idx=0;idx<n;idx++){
                String s=q.poll();
                if(s.equals(endWord))
                    return count;
                char[]arr=s.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char temp=arr[i];
                    arr[i]='*';
                    List<String>next=map.get(new String(arr));
                    if(next!=null){
                        for(String word:next){
                            if(!visited.contains(word)){
                                q.offer(word);
                                visited.add(word);
                            }
                        }
                    }
                    arr[i]=temp;
                }
           }
        }
        return 0;
    }
}