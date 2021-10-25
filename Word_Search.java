public class Word_Search {
    
}
class Solution {
    
    boolean[][] visitedCells;
   
   public boolean depthFirstSearch(char[][] board, int i, int j, int index, String word){
//         account for error scenarios first because it is a recursive function
       
       if(index == word.length()){
           return true;
       }
       
       if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || visitedCells[i][j] || word.charAt(index) != board[i][j]){
           return false;
       }
       
       
       
       visitedCells[i][j] = true;
       if(
       depthFirstSearch(board, i + 1, j, index + 1, word) ||
       depthFirstSearch(board, i - 1, j, index + 1, word) ||   
       depthFirstSearch(board, i, j + 1, index + 1, word) ||
       depthFirstSearch(board, i, j - 1, index + 1, word)){
           return true;
       }
       
       visitedCells[i][j] = false;
       return false;
   }

   
   public boolean exist(char[][] board, String word) {
       visitedCells = new boolean[board.length][board[0].length];
       boolean returnValue = false;
       int i = 0;
       int j = 0;
       
       for(i = 0; i < board.length; i++){
           for(j = 0; j < board[i].length; j++){
               if(board[i][j] == word.charAt(0)){
                   returnValue = depthFirstSearch(board, i, j, 0, word);
                   if(returnValue == true){
                       return returnValue;
                   }
               }
           }
       }
       
       
       return returnValue;
   }
}