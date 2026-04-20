class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i = 0; i <= k; i++){
            int[] temp = dist.clone();
            for(int j = 0; j < flights.length; j++){
                int u = flights[j][0];
                int v = flights[j][1];
                int p = flights[j][2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + p < temp[v]){
                    temp[v] = dist[u] + p;
                }
            }
            dist = temp;
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}