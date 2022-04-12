class Solution {
    public boolean checkInBounds(int[][] board, int currentRow, int currentCol){
        if(currentRow < 0 || currentRow >= board.length || currentCol < 0 || currentCol >= board[currentRow].length){
            return false;
        }
        
        
        return true;
    }
    
    public void breadthFirstSearch(int[][] board, HashMap<int[], Integer> theMap, int currentRow, int currentCol){        
        int i = 0;
        int numOnes = 0;
        
        if(checkInBounds(board, currentRow - 1, currentCol)){
            if(board[currentRow - 1][currentCol] == 1){
                numOnes++;
            }
        }
        
        if(checkInBounds(board, currentRow + 1, currentCol)){
            if(board[currentRow + 1][currentCol] == 1){
                numOnes++;
            }
        }
        
        if(checkInBounds(board, currentRow, currentCol - 1)){
            if(board[currentRow][currentCol - 1] == 1){
                numOnes++;
            }
        }
        
        if(checkInBounds(board, currentRow, currentCol + 1)){
            if(board[currentRow][currentCol + 1] == 1){
                numOnes++;
            }       
        }
        
        if(checkInBounds(board, currentRow - 1, currentCol - 1)){
            if(board[currentRow - 1][currentCol - 1] == 1){
                numOnes++;
            }
        }
        
        if(checkInBounds(board, currentRow + 1, currentCol + 1)){
            if(board[currentRow + 1][currentCol + 1] == 1){
                numOnes++;
            }   
        }
        
        
        if(checkInBounds(board, currentRow - 1, currentCol + 1)){
            if(board[currentRow - 1][currentCol + 1] == 1){
                numOnes++;
            }
        }
        
        if(checkInBounds(board, currentRow + 1, currentCol - 1)){
            if(board[currentRow + 1][currentCol - 1] == 1){
                numOnes++;
            }
        }
        
        if(board[currentRow][currentCol] == 0){
            if(numOnes == 3){
                theMap.put(new int[]{currentRow, currentCol}, 1);
            }
        } else {
            if(numOnes < 2){
                theMap.put(new int[]{currentRow, currentCol}, 0);
            } else if (numOnes == 2 || numOnes == 3){
                theMap.put(new int[]{currentRow, currentCol}, 1);
            } else if (numOnes > 3){
                theMap.put(new int[]{currentRow, currentCol}, 0);
            }
        }
        
    }
    
    public void gameOfLife(int[][] board) {
        int i = 0;
        int j = 0;
        HashMap<int[], Integer> theMap = new HashMap<int[], Integer>();
        int currentRow = 0;
        int currentCol = 0;
        
        for(i = 0; i < board.length; i++){
            for(j = 0; j < board[i].length; j++){
                breadthFirstSearch(board, theMap, i, j);
            }
        }
        
        
        for(int[] currentPoints : theMap.keySet()){
            currentRow = currentPoints[0];
            currentCol = currentPoints[1];
            
            board[currentRow][currentCol] = theMap.get(currentPoints);
        }
        
    }
}