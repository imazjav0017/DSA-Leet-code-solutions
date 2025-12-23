class Solution {
    public int first(String[]prods,String s, int start){
        int n=prods.length;
        if(start==-1)return -1;
        int min=-1;
        List<String>res=new ArrayList<>();
        for(int i=start;i<n;i++){
            if(prods[i].startsWith(s)){
                min=i;
                break;
            }
        }
        return min;
    }
    public List<String>search(String[]prods,String s,int start){
        int n=prods.length;
        List<String>res=new ArrayList<>();
        if(start==-1)return res;
        for(int i=start;i<n;i++){
            if(prods[i].startsWith(s)){
                res.add(prods[i]);
                if(res.size()==3)break;
            }
        }
        return res;
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>>res=new ArrayList<>();
        Arrays.sort(products);
        //System.out.println(Arrays.toString(products));
        int n=searchWord.length();
        String s="";
        int start=0;
        for(int i=0;i<n;i++){
            s+=searchWord.charAt(i);
            start=first(products,s,start);
            //System.out.println(start);
            List<String>list=search(products,s,start);
            res.add(list);
        }
        return res;
    }
}