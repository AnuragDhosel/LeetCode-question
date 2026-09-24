class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= 9){
                if(nums[i] == i) return i;
            }
            else if(nums[i] > 9){
                int sum = sumOfDigit(nums[i]);
                if(sum == i) return i;
            }
        }

        return -1;
    }
    public int sumOfDigit(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}