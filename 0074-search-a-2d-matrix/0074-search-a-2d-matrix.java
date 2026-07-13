class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int c = matrix.length;
        int r = matrix[0].length;

        int ansC = 0;
        for(int i=0; i<c; i++){
            if(matrix[i][r-1] < target){
                ansC++;
            }
        }
        if(ansC == c) return false;

        int st = 0;
        int end = r-1;
        while(st <= end){
            int mid = st + (end - st)/2;

            if(matrix[ansC][mid] == target){
                return true;
            }
            else if(matrix[ansC][mid] > target){
                end = mid - 1;
            }
            else{ // matrix[ansC][mid] < target
                st = mid + 1;
            }
        }

        return false;

    }
}