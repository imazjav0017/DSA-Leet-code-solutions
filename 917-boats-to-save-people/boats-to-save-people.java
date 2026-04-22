class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        int res=0;
        Arrays.sort(people);
        int i=0,j=n-1;
        while(i<=j){
            int sum=people[i]+people[j];
                if(i==j || sum<=limit){
                  i++;
                  j--;
                  res++;
                }
                else{
                  j--;
                  res++;
                }
            
        }
        return res;
    }
}