class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            adj.get(u).add(new Pair(v, cost));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        dist[src] = 0;
        q.add(new int[]{src, 0, 0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int u = curr[0];
            int cost = curr[1];
            int stops = curr[2];
            if(stops == k + 1) continue;
            for(Pair adjPair : adj.get(u)){
                int v = adjPair.node;
                int wt = adjPair.dist;
                if(cost + wt < dist[v]){
                    dist[v] = cost + wt;
                    q.add(new int[]{v, dist[v], stops + 1});
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }

    class Pair{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}