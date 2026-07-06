class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int st = maximumValue(weights);
        int end = sumOfArray(weights);
        int ans = 0;

        while(st <= end){
            int mid = st + (end - st)/2; // capacity

// calculate How Many Days It Takes on Converyor Belt for shipped
            int takeDay = calculateDaysRequired(weights , mid);

            if(takeDay <= days){
                ans = mid;
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }

        return ans;
    }

    public int calculateDaysRequired(int [] weights , int shipCapi){
        int takeDays = 1;
        int load = 0;
        for(int i=0; i<weights.length; i++){
            load += weights[i];
            if(load > shipCapi){
                takeDays++;
                load = weights[i];
            }
        }            
        
        return takeDays;
    }

    public int sumOfArray(int [] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
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