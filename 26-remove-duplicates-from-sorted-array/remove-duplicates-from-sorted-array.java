class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        [0,0,1,1,1,2,2,3,3,4]
        0-> next non zero at index 2:
        [0,1,0,1,1,2,2,3,3,4];
        1-> next non 1 at index 5,swap();
        [0,1,2,0,1,1,2,3,3,4]
        2-> next non 2 at index 7, swap():
        [0,1,2,3,0,1,1,1,2,3,4].
        3-> next non 3 at index last, swap():
        */

        int counter=1;
        int n=nums.length;
        int p=0;
        for (int i=0;i<n-1;i++){
            //find next non pointer value:
            int j=i+1;
            while(nums[j]<=nums[i]){
                j++;
                if(j==n){
                    return counter;
                }
            }
            int temp=nums[i+1];
            nums[i+1]=nums[j];
            nums[j]=temp;
            counter++;
        }
        return counter;
    }
}