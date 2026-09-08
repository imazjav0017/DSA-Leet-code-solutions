class Item{
    int profit;
    int capital;
    Item(int profit,int capital){
        this.profit=profit;
        this.capital=capital;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Item[]items=new Item[profits.length];
        for(int i=0;i<profits.length;i++){
            items[i]=new Item(profits[i],capital[i]);
        }
        Arrays.sort(items,(a,b)->Integer.compare(a.capital,b.capital));
        PriorityQueue<Item>pq=new PriorityQueue<>((a,b)->Integer.compare(b.profit,a.profit));
        int i=0;
        for(int step=0;step<k;step++){
            while(i<items.length && items[i].capital<=w){
                pq.offer(items[i]);
                i++;
            }
            if(pq.isEmpty()) break;

            Item best=pq.poll();
            w+=best.profit;
        }
        return w;
    }
}