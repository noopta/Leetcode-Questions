class Solution {
    public int depthFirstSearch(int[][] grid, int currentRow, int currentCol, int currentArea) {
        if (currentRow < 0 || currentRow >= grid.length || currentCol < 0 || currentCol >= grid[currentRow].length
                || grid[currentRow][currentCol] == 0) {
            return currentArea;
        }

        if (grid[currentRow][currentCol] == 1) {
            grid[currentRow][currentCol] = 0;
            currentArea++;
        }

        currentArea += depthFirstSearch(grid, currentRow + 1, currentCol, 0);
        currentArea += depthFirstSearch(grid, currentRow - 1, currentCol, 0);
        currentArea += depthFirstSearch(grid, currentRow, currentCol + 1, 0);
        currentArea += depthFirstSearch(grid, currentRow, currentCol - 1, 0);

        return currentArea;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int i = 0;
        int j = 0;

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, depthFirstSearch(grid, i, j, 0));
                }
            }
        }

        return maxArea;
    }
}