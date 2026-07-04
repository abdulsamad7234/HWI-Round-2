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
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> {
            if(a.time == b.time){
                return Integer.compare(b.power, a.power);
            }else{
                return Long.compare(a.time, b.time);
            }
        });
        pq.offer(new Triplet(source, 0, power));
        dist[source][power] = 0;
        
        while(!pq.isEmpty()){
            Triplet curr = pq.poll();
            int u = curr.node;
            long t = curr.time;
            int p = curr.power;
            if(u == target) return new long[]{t, p};
            if(t > dist[u][p]) continue;
            for(Pair adjPair : adjList.get(u)){
                int v = adjPair.node;
                long newTime = t + adjPair.time;
                int newPower = p - cost[u];

                if(newPower >= 0 && newTime < dist[v][newPower]){
                    dist[v][newPower] = newTime;
                    pq.add(new Triplet(v, newTime, newPower));
                }
            }
        }
        return new long[]{-1, -1};
    }

    class Pair{
        int node;
        int time;
        Pair(int node, int time){
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