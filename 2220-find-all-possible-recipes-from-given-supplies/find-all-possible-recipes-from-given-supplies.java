class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,Integer>indegrees=new HashMap<>();
        Map<String,List<String>>graph=new HashMap<>();
        for(int i=0;i<recipes.length;i++){
            List<String>ingList=ingredients.get(i);
            String recipe=recipes[i];
            indegrees.put(recipe,ingList.size());
            for(String s:ingList){
                List<String>list=graph.getOrDefault(s,new ArrayList<>());
                list.add(recipe);
                graph.put(s,list);
            }
        }
        Queue<String>q=new ArrayDeque<>();
        for(String s:supplies){
            q.offer(s);
        }
        List<String>res=new ArrayList<>();
        while(!q.isEmpty()){
            String s=q.poll();
            if(indegrees.containsKey(s)){
                res.add(s);
            }
            for(String next:graph.getOrDefault(s,new ArrayList<>())){
                indegrees.put(next,indegrees.get(next)-1);
                if(indegrees.get(next)==0){
                    q.offer(next);
                }
            }
        }
        return res;
    }
}