class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        int parent[] = new int[n];
        int size[] = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int i = 0; i < n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(union(u, v, parent, size) == false){
                return new int[]{u, v};                                                                
            }
        }
        return new int[]{};
    }

    int find(int x, int parent[]){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    boolean union(int x, int y, int parent[], int size[]){
        int P_X = find(x, parent);
        int P_Y = find(y, parent);
        if(P_X != P_Y){
            if(size[P_X] >= size[P_Y]){
                parent[P_Y] = P_X;
                size[P_X] += size[P_Y];
            }else{
                parent[P_X] = P_Y;
                size[P_Y] += size[P_X];
            }
            return true;
        }
        return false;
    }
}