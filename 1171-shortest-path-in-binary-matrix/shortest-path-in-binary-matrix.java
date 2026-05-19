class Solution {
    static int[][] dir = {{0, 0, -1, 1, -1, 1, -1, 1}, {-1, 1, 0, 0, -1, -1, 1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1){
            return -1;
        }
        boolean[][] vis = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        vis[0][0] = true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int dist = curr.dist;
            if(row == n - 1 && col == n - 1) return dist;
            for(int k = 0; k < 8; k++){
                int newRow = row + dir[0][k];
                int newCol = col + dir[1][k];
                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && !vis[newRow][newCol] && grid[newRow][newCol] == 0){
                    vis[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol, dist + 1));
                }
            }
        }
        return -1;
    }

    static class Pair{
        int row;
        int col;
        int dist;
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}