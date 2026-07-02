class Solution {
    static int[] size;
    static int[] parent;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        size = new int[n];
        parent = new int[n];
        for(int i = 0; i < n; i++){
            size[i] = 1;
            parent[i] = i;
        }
        
        int provinces = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && isConnected[i][j] == 1){
                    if(union(i, j) == true){
                        provinces--;
                    }
                }
            }
        }
        return provinces;
    }

    boolean union(int a, int b){
        int parent_a = find(a);
        int parent_b = find(b);
        if(parent_a != parent_b){
            if(size[parent_a] > size[parent_b]){
                parent[parent_b] = parent_a;
                size[parent_a] += size[parent_b];
            }else{
                parent[parent_a] = parent_b;
                size[parent_b] += size[parent_a];
            }
            return true;
        }else{
            return false;
        }
    }

    int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}