class Solution {
    public int splitArray(int[] nums, int k) {
        // suppose k == nums.length , largest sum is the maximum element which is st
        int st = Integer.MIN_VALUE; 
        int end = 0; // suppose k == 0 , largest sum is sum of array
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            st = Math.max(nums[i] , st);
            end += nums[i];
        }

        while(st <= end){
            int mid = st + (end - st)/2;

            int count = noOfSubarrayPossible(nums , mid);

            if(count <= k){
                ans = mid;
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }
        return ans;
    }

    public int noOfSubarrayPossible(int [] arr , int maxSum){
        int count = 1;
        int currSum = 0;

        for(int i=0; i<arr.length; i++){
            if(currSum + arr[i] <= maxSum){
                currSum += arr[i];
            }
            else{
                count++;
                currSum = arr[i];
            }
        }

        return count;
    }
}