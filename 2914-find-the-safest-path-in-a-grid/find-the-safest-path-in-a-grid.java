class Solution {
    int[][] dir = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) return 0;

        int[][] arr = new int[n][n];
        Queue<int[]> q  = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){
                    arr[i][j] = 1;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int dist = arr[i][j];
            for(int k = 0; k < 4; k++){
                int ni = i + dir[0][k];
                int nj = j + dir[1][k];
                if(ni >= 0 && ni < n && nj >= 0 && nj < n && arr[ni][nj] == 0){
                    arr[ni][nj] = dist + 1;
                    q.add(new int[]{ni, nj});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.offer(new int[]{0, 0, arr[0][0]});
        arr[0][0] *= -1;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int sf = curr[2];
            if(i == n - 1 && j == n - 1) return sf - 1;
            for(int k = 0; k < 4; k++){
                int ni = i + dir[0][k];
                int nj = j + dir[1][k];
                if(ni >= 0 && ni < n && nj >= 0 && nj < n && arr[ni][nj] >= 0){
                    pq.offer(new int[]{ni, nj, Math.min(sf, arr[ni][nj])});
                    arr[ni][nj] *= -1;
                }
            }
        }

        return -(arr[n - 1][n - 1] - 1);
    }
}