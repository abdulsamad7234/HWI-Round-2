class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[n];
        for(int i = 0; i < n + 1; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == false){
                bfs(i, adj, vis);
                count++;
            }
        }
        return count;
    }

    void bfs(int src, List<List<Integer>> adj, boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int adjNode : adj.get(node)){
                if(!vis[adjNode]){
                    vis[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }
    }
}