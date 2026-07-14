class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        // binary Search perform on column wise
        int st = 0;
        int end = col - 1;

        while(st <= end){
            int mid = st + (end - st)/2; // index

            // find the maximum element row in mid column
            int Row = findMaxElementRow(mat , mid);

            int left = (mid-1 >= 0) ? mat[Row][mid-1] : -1;
            int right = (mid+1 < col) ? mat[Row][mid+1] : -1;

            if(left < mat[Row][mid] && mat[Row][mid] > right){
                return new int[]{Row , mid};
            }
            else if(left < mat[Row][mid]){ // && mat[Row][mid] < right
                st = mid + 1;
            }
            else{ // left > mat[Row][mid] && mat[Row][mid] > right
                end = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
    public int findMaxElementRow(int [][] mat , int col){
        int maxIdx = 0;
        int maxEle = Integer.MIN_VALUE;

        for(int i=0; i<mat.length; i++){
            if(mat[i][col] > maxEle){
                maxEle = mat[i][col];
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}