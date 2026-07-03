class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // if(time.length == 1) return time[0] * totalTrips;

        long st = 1;
        long end = minimumValue(time) * totalTrips;
        long ans = 0;

        while(st <= end){
            long mid = st + (end - st)/2;

            long trips = totalCompletedTrips(time , mid);  // total completed trips in mid hour

            if(trips >= totalTrips){ 
                ans = mid; // bcz we have to write minimum hour
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }

        return ans;
    }

    public long minimumValue(int [] arr){
        long mini = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            mini = Math.min(arr[i] , mini);
        }
        return mini;
    }

    public long totalCompletedTrips(int [] time , long hour){
        long completedTrips = 0;
        for(int i=0; i<time.length; i++){
        // check notes 
            long trips = hour / time[i];
            completedTrips += trips;
        }
        return completedTrips;
    }
}