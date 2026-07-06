class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int st = 1;
        int end = maximumValue(nums);
        int ans = 0;

        while(st <= end){
            int mid = st + (end - st)/2;

            int currSum = divisionsResult(nums , mid);

            if(currSum <= threshold){
                ans = mid;
                end = mid - 1;
            }
            else{ // currSum > threshold
                st = mid + 1;
            }
        }
        return ans;
    }
    public int divisionsResult(int [] arr , int divisor){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            double result = (double)arr[i] / (double)divisor;
            sum += Math.ceil(result);
        }
        return sum;
    }

    public int maximumValue(int [] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(arr[i] , max);
        }
        return max;
    }
}