class Solution {
    static int[][] dir = {{0, 0, -1, 1}, {-1, 1, 0, 0}};
    static int m;
    static int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        int orgColor = image[sr][sc];
        if(orgColor == color) return image;
        bfs(sr, sc, orgColor, color, image);
        return image;
    }

    public void bfs(int sr, int sc, int orgColor, int color, int[][] image){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        image[sr][sc] = color;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            for(int k = 0; k < 4; k++){
                int nr = r + dir[0][k];
                int nc = c + dir[1][k];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == orgColor){
                    image[nr][nc] = color;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }

    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}