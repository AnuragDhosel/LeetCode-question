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

        for(int i=0; i<r; i++){
            if(ansC < c && matrix[ansC][i] == target){
                return true;
            }
        }

        return false;
    }
}