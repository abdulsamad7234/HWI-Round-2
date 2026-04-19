class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int adjNode : adj.get(curr)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0){
                    q.add(adjNode);
                }
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}