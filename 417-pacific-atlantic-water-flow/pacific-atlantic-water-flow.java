class Solution {

    int m, n;
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from Pacific borders (top row and left column)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
        }

        // DFS from Atlantic borders (bottom row and right column)
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic, m - 1, j);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {

        if (visited[row][col]) return;

        visited[row][col] = true;

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                continue;

            // Reverse flow:
            // We can move only to cells having height >= current cell.
            if (heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, visited, newRow, newCol);
            }
        }
    }
}