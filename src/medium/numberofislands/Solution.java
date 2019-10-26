package medium.numberofislands;

class Solution {
    private void markIsland(char[][] grid, boolean[][] counted, int r, int c, int rl, int cl) {
        if (r<0 || c<0 || r>=rl || c>=cl)
            return;
        if (counted[r][c] || grid[r][c]=='0')
            return;
        counted[r][c] = true;
        markIsland(grid, counted, r-1, c, rl, cl);
        markIsland(grid, counted, r, c-1, rl, cl);
        markIsland(grid, counted, r, c+1, rl, cl);
        markIsland(grid, counted, r+1, c, rl, cl);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rl = grid.length;
        int cl = grid[0].length;
        boolean[][] counted = new boolean[rl][];
        for (int i=0; i<rl; i++)
            counted[i] = new boolean[cl];
        int islands = 0;
        for (int r=0; r<rl; r++) {
            for (int c=0; c<cl; c++) {
                if (!counted[r][c])
                    if (grid[r][c] == '1') {
                        islands++;
                        markIsland(grid, counted, r, c, rl, cl);
                    }
            }
        }
        return islands;
    }
}