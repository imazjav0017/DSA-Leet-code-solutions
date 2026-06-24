class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,Integer>indegree=new HashMap<>();
        Map<String,List<String>>ingToRecipe=new HashMap<>();
        for(int i=0;i<recipes.length;i++){
            String recipe=recipes[i];
            List<String>ingList=ingredients.get(i);
            indegree.put(recipe,ingList.size());
            for(String ing:ingList){
                ingToRecipe.computeIfAbsent(ing,k->new ArrayList<>()).add(recipe);
            }
        }
        Queue<String>q=new ArrayDeque<>();
        for(String s:supplies){
            q.offer(s);
        }
        List<String>res=new ArrayList<>();
        while(!q.isEmpty()){
            String item=q.poll();
            if(indegree.containsKey(item)){
                res.add(item);
            }
            List<String>dependents=ingToRecipe.get(item);
            if(dependents!=null){
                for(String recipe:dependents){
                    indegree.put(recipe,indegree.getOrDefault(recipe,0)-1);
                    if(indegree.get(recipe)==0)
                        q.offer(recipe);
                }
            }
        }
        return res;
    }
}