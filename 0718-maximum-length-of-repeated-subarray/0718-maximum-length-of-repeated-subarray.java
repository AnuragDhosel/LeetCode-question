class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
            
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                int x = i;
                int y = j;
                int count = 0;
                
                while(x<n && y<m && nums1[x] == nums2[y]){
                    x++;
                    y++;
                    count++;
                }
                max = Math.max(max , count);
            }
        }
        
        return max;
    }
}