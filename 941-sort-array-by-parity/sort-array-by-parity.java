class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int writeEven=0,writeOdd=n-1;
        while(writeEven<writeOdd){
            if(nums[writeEven]%2!=0){
                if(nums[writeOdd]%2==0){
                    int temp=nums[writeEven];
                    nums[writeEven]=nums[writeOdd];
                    nums[writeOdd]=temp;
                    writeEven++;
                    writeOdd--;
                }
                else{
                    while(writeOdd>writeEven && nums[writeOdd]%2!=0)writeOdd--;
                    int temp=nums[writeEven];
                    nums[writeEven]=nums[writeOdd];
                    nums[writeOdd]=temp;
                }
            }
            else{
                writeEven++;
            }
            // for(int x:nums){
            //     System.out.println(x);
            // }
            // System.out.println("___________");
        }
        return nums;
        
    }
}