class Solution { 
    static long[] finishTime;
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        finishTime = new long[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }
        solve(0, adjList, baseTime);
        return finishTime[0];
    }

    public void solve(int src, List<List<Integer>> adjList, int[] baseTime){
        if(adjList.get(src).size() == 0){
            finishTime[src] = baseTime[src];
            return;
        }
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int adjNode : adjList.get(src)){
            solve(adjNode, adjList, baseTime);
            min = Math.min(min, finishTime[adjNode]);
            max = Math.max(max, finishTime[adjNode]);
        }
        long ownDuration = max - min + baseTime[src];
        finishTime[src] = ownDuration + max;
    }
}