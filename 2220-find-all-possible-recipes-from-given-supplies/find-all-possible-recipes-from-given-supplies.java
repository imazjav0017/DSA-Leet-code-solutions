class Solution {
    boolean dfs(Map<String,List<String>>adj,String recipe,Set<String>supply,Set<String> visit){
        visit.add(recipe);
        List<String>ing=adj.get(recipe);
        for(String i:ing){
            if(supply.contains(i))
                continue;
            else if(!visit.contains(i) && adj.get(i)!=null)
                {
                    visit.add(i);
                    boolean res= dfs(adj,i,supply,visit);
                    if(!res)
                        return false;
                    else
                        supply.add(i);
                }
            else 
                return false;
        }
        supply.add(recipe);
        return true;
    }
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,List<String>>adj=new HashMap<>();
        int n=recipes.length;
        for(int i=0;i<n;i++){
            adj.put(recipes[i],ingredients.get(i));
        }
        Set<String>supplyNew=new HashSet<>();
        for(String x: supplies){
            supplyNew.add(x);
        }
        List<String>res=new ArrayList<>();
        for(int i=0;i<n;i++){
            Set<String> visit=new HashSet<>();
            if(supplyNew.contains(recipes[i])|| dfs(adj,recipes[i],supplyNew,visit))
                res.add(recipes[i]);
        }
        return res;
    }
}