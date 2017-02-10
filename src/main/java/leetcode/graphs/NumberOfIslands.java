package leetcode.graphs;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 */
public class NumberOfIslands {

    private final char LAND = '1';
    private final char WATER = '0';

    /**
     * DFS - flood fill algorithm
     */
    public int numIslands(char[][] grid) {
        if(grid == null)
            return 0;

        int numOfIslands = 0;

        for (int x = 0; x < grid.length; x++)
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == LAND) {
                    numOfIslands++;
                    exploreIsland(x, y, grid);
                }
            }

        return numOfIslands;
    }

    private void exploreIsland(int x, int y, char[][] grid) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == LAND) {
            grid[x][y] = WATER;
            exploreIsland(x - 1, y, grid);
            exploreIsland(x + 1, y, grid);
            exploreIsland(x, y - 1, grid);
            exploreIsland(x, y + 1, grid);
        }
    }

    public static void main(String[] args) {
        char[][] map = {{'1','1','0'},{'1','0','0'},{'0','0','0'}};
        System.out.println(new NumberOfIslands().numIslands(map));
    }
}
