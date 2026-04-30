class Solution {
    static int m;
    static int n;
    static boolean[][] vis;
    static int[][] dir = {{0, 0, -1, 1}, {-1, 1, 0, 0}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        int components = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    bfs(i, j, grid);
                    components++;
                }
            }
        }
        return components;
    }

    public void bfs(int i, int j, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        vis[i][j] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int k = 0; k < 4; k++){
                int nr = r + dir[0][k];
                int nc = c + dir[1][k];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && grid[nr][nc] == '1'){
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}