class Solution {
    
    public void depthFirstSearch(int[][] image, int currentRow, int currentCol, int newColor, int originalColor, boolean[][] visitedSet){
        if(currentRow < 0 || currentRow >= image.length || currentCol < 0 || currentCol >= image[currentRow].length || visitedSet[currentRow][currentCol] || image[currentRow][currentCol] != originalColor){
            return;
        }
        
        image[currentRow][currentCol] = newColor;
        visitedSet[currentRow][currentCol] = true;
        
        depthFirstSearch(image, currentRow + 1, currentCol, newColor, originalColor, visitedSet);
        depthFirstSearch(image, currentRow - 1, currentCol, newColor, originalColor, visitedSet);
        depthFirstSearch(image, currentRow, currentCol + 1, newColor, originalColor, visitedSet);
        depthFirstSearch(image, currentRow, currentCol - 1, newColor, originalColor, visitedSet);
        
        
    } 
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int colorToChange = image[sr][sc];
        boolean[][] visitedSet = new boolean[image.length][image[sr].length];
        
        depthFirstSearch(image, sr, sc, newColor, colorToChange, visitedSet);
    
        return image;
    }
}