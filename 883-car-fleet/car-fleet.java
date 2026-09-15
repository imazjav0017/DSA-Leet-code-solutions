class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][]cars=new int[n][2];
        for(int i=0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        Arrays.sort(cars,(a,b)->Integer.compare(b[0],a[0]));
        int fleets=0;
        double fleetTime=0;
        for(int[]car:cars){
            int pos=car[0],spd=car[1];
            double time=(double)(target-pos)/spd;
            if(time>fleetTime){
                fleetTime=time;
                fleets++;
            }
        }
        return fleets;
    }
}