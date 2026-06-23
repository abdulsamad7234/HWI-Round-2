class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adjList.get(u).add(new Pair(v, wt));
        }

        int[][] dist = new int[n][k + 1];
        for(int i = 0; i < dist.length; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0, 1});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int wt = curr[1];
            int count = curr[2];
            if(wt > dist[u][count]) continue;
            if(u == n - 1) return wt;
            for(Pair adjPair : adjList.get(u)){
                int v = adjPair.node;
                int weight = adjPair.weight;
                int newCount = (labels.charAt(u) == labels.charAt(v)) ? count + 1 : 1;
                if(newCount <= k){
                    if(wt + weight < dist[v][newCount]){
                        dist[v][newCount] = weight + wt;
                        pq.offer(new int[]{v, dist[v][newCount], newCount});
                    }
                }
            }
        }
        return -1;
    }

    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
}