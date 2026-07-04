class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k){ // we can't make m bouquets with bloomDay
            return -1;
        }

// no bouquet can be made before the minimum bloom day
        int st = minimumElement(bloomDay);
// By the maximum bloom day, all flowers will have bloomed.        
        int end = maximumElement(bloomDay);

        int ans = -1;

        while(st <= end){
            int mid = st + (end - st)/2;

            int bouquet = BouquetMakeInMidDays(bloomDay , mid , k);

            if(bouquet >= m){
                ans = mid;
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }

        return ans;
    }

// dth day me kitne bouquet ban payege, agar 1 bouquet banne me k phool lagte hain , 
// or ith phool ko khilne me bloomDay[i] day lagte hain 
    public int BouquetMakeInMidDays(int [] bloomDay , int d , int k){
        int bouquet = 0;
        int adjacent = 0; // adjacent floowers
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= d){
                adjacent++;
                if(adjacent == k){
                    bouquet++;
                    adjacent = 0;
                }
            }
            else{
                adjacent = 0;
            }
        }

        return bouquet;
    }

    public int maximumElement(int [] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max , arr[i]);
        }
        return max;
    }

    public int minimumElement(int [] arr){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            min = Math.min(min , arr[i]);
        }
        return min;
    }
}