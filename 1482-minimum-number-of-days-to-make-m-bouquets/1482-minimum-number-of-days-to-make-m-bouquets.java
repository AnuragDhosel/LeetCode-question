class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k){ // we can't make m bouquets with bloomDay
            return -1;
        }

        int st = 1;
        int end = maximumElement(bloomDay); // max element jitne day me sale flower bloom ho jayege
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

    public int maximumElement(int [] arr){
        int max = 0;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max , arr[i]);
        }
        return max;
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
}