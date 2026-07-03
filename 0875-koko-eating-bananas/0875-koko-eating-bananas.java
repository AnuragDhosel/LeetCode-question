class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int st = 1;
        int end = MaximumElement(piles);
        int ans = 0;

        while(st <= end){
            int mid = st + (end - st)/2; // per hour i can eat mid number of bananas

            long takeHours = findHowManyHours(piles , mid);

            if(takeHours <= h){
                ans = mid;
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }

        return ans;
    }
    public int MaximumElement(int [] arr){
        int max = 0;
        for(int i=0; i<arr.length; i++){
            max = Math.max(arr[i] , max);
        }
        return max;
    }
    public long findHowManyHours(int [] arr , int capasity){
        long count = 0;
        for(int i=0; i<arr.length; i++){
            count = count + (arr[i] / capasity);
            if(arr[i] % capasity != 0) count++;
        }
        return count;
    }
}