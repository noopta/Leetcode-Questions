class Solution {
    
    public boolean binarySearch(int[] matrixRow, int left, int right, int target){
        if(left > right){
            return false;
        }
        
        int midPoint = left + ((right - left) / 2);
        
        // 1 2 3 4 5 6 7 8
        
        if(matrixRow[midPoint] == target){
            return true;
        } else if (matrixRow[midPoint] > target){
            return binarySearch(matrixRow, left, midPoint - 1, target);
        } else if (matrixRow[midPoint] < target){
            return binarySearch(matrixRow, midPoint + 1, right, target);
        }
        
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = 0;
        
        for(i = 0; i < matrix.length; i++){
            if(binarySearch(matrix[i], 0, matrix[i].length - 1, target)){
                return true;
            }
        }
        
        
        return false;
    }
}