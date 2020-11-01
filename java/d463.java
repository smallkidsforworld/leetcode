public class d463 {
    public int islandPerimeter(int[][] grid) {
        int cir = 0;
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] != 0)
                    cir += (judge(i - 1, j, grid) + judge(i + 1, j, grid) + judge(i, j - 1, grid)
                            + judge(i, j + 1, grid));
            }
        return cir;
    }

    private int judge(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 1;
        } else
            return 0;
    }
}