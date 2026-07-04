class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            adjList.get(u).add(new Pair(v, t));
        }
        
        long[][] dist = new long[n][power + 1];
        for(long[] row : dist){
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> {
            if(a.time == b.time){
                return Long.compare(b.power, a.power);
            }else{
                return Long.compare(a.time, b.time);
            }
        });

        dist[source][power] = 0;
        pq.offer(new Triplet(source, 0, power));
        while(!pq.isEmpty()){
            Triplet curr = pq.poll();
            int u = curr.node;
            long t = curr.time;
            int p = curr.power;
            if(t > dist[u][p]) continue;
            if(u == target){
                return new long[]{t, p};
            }
            for(Pair adjPair : adjList.get(u)){
                int adjNode = adjPair.node;
                long adjTime = adjPair.time;

                int newPower = p - cost[u];
                long newTime = t + adjTime;
                if(newPower >= 0 && newTime < dist[adjNode][newPower]){
                    dist[adjNode][newPower] = newTime;
                    pq.add(new Triplet(adjNode, newTime, p - cost[u]));
                }
            }
        }
        return new long[]{-1, -1};
    }

    class Pair{
        int node;
        long time;
        Pair(int node, long time){
            this.node = node;
            this.time = time;
        }
    }

    class Triplet{
        int node;
        long time;
        int power;
        Triplet(int node, long time, int power){
            this.node = node;
            this.time = time;
            this.power = power;
        }
    }
}