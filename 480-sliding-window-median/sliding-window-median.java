class Solution {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    Map<Integer, Integer> delayed;
    int smallSize = 0;
    int largeSize = 0;
    public double[] medianSlidingWindow(int[] nums, int k) {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        delayed = new HashMap<>();
        double[]res=new double[nums.length-k+1];
        int idx=0;
        for(int i=0;i<k;i++){
            add(nums[i]);
        }
        res[idx++]=median(k);
        for(int right=k;right<nums.length;right++){
            int left=right-k;
            remove(nums[left]);
            add(nums[right]);
            res[idx++]=median(k);
        }
        return res;
    }
    void remove(int num){
        delayed.put(num,delayed.getOrDefault(num,0)+1);
        if(num<=small.peek()){
            smallSize--;
            if(num==small.peek())
                prune(small);
        }
        else{
            largeSize--;
            if(!large.isEmpty() && num==large.peek())
                prune(large);
        }
        balance();
    }
    void add(int num){
        if(small.isEmpty() || num<=small.peek()){
            small.offer(num);
            smallSize++;
        }else{
            large.offer(num);
            largeSize++;
        }
        balance();
    }
    void balance(){
        if(smallSize>largeSize+1){
            large.offer(small.poll());
            smallSize--;
            largeSize++;
            prune(small);
        }
        else if(smallSize<largeSize){
            small.offer(large.poll());
            smallSize++;
            largeSize--;
            prune(large);
        }
    }
    void prune(PriorityQueue<Integer>heap){
        while(!heap.isEmpty()){
            int num=heap.peek();
            if(delayed.getOrDefault(num,0)==0)
                break;
            heap.poll();
            delayed.put(num,delayed.get(num)-1);
            if(delayed.get(num)==0)
                delayed.remove(num);
        }
    }
    double median(int k){
        if(k%2==1)
        return small.peek();
        else 
         return ((double) small.peek() + (double) large.peek()) / 2.0;
    }
}