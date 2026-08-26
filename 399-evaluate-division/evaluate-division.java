class Solution {

    static class Edge {
        String node;
        double weight;

        Edge(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    double dfs(String current,String target, Map<String,List<Edge>>graph,Set<String>visited, double product){
        if(current.equals(target)){
            return product;
        }
        visited.add(current);
        for(Edge edge: graph.get(current)){
            if(!visited.contains(edge.node)){
                double result=dfs(edge.node,target,graph,visited,product*edge.weight);
                if(result!=-1.0)
                    return result;
            }
        }
        return -1.0;
    }
    public double[] calcEquation(
        List<List<String>> equations,
        double[] values,
        List<List<String>> queries
    ) {
        Map<String,List<Edge>>graph=new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            double value=values[i];
            graph.putIfAbsent(a,new ArrayList<>());
            graph.putIfAbsent(b,new ArrayList<>());
            graph.get(a).add(new Edge(b,value));
            graph.get(b).add(new Edge(a,(1/value)));
        }
        double[]result=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String source=queries.get(i).get(0);
            String target=queries.get(i).get(1);
            if(!graph.containsKey(source) || !graph.containsKey(target)){
                result[i]=-1;
                continue;
            }
            result[i]=dfs(source,target,graph,new HashSet<>(),1.0);
        }
        return result;
    }
}