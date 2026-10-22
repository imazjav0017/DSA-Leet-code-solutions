class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,(a,b)->Integer.compare(a[0],b[0]));
        int max=0;
        int covered=0;
        int right=0;
        int n=tiles.length;
        for(int left=0;left<n;left++){
            right=Math.max(right,left);
            int carpetEnd=tiles[left][0]+carpetLen-1;

            //fully Covered tiles:
            while(right<n && tiles[right][1]<=carpetEnd){
                covered+=tiles[right][1]-tiles[right][0]+1;
                right++;
            }
            int total=covered;
            //partially covered tiles:
            if(right<n && tiles[right][0]<=carpetEnd){
                total+=carpetEnd-tiles[right][0]+1;
            }
            max=Math.max(max,total);
            if(left<right){
                covered-=tiles[left][1]-tiles[left][0]+1;
            }
        }
        return max;
    }
}