class TreeAncestor {
    static int[][] parent;
    static int col;
    public TreeAncestor(int n, int[] arr) {
        col = ((int)(Math.log(n) / Math.log(2))) + 1;
        parent = new int[n][col];
        for(int node = 0; node < n; node++){
            parent[node][0] = arr[node];
        }
        for(int j = 1; j < col; j++){
            for(int node = 0; node < n; node++){
                if(parent[node][j - 1] == -1){
                    parent[node][j] = -1;
                }else{
                    parent[node][j] = parent[parent[node][j - 1]][j - 1];
                }
            }
        }

    }
    
    public int getKthAncestor(int node, int k) {
        for(int j = 0; j < col; j++){
            if((k & (1 << j)) != 0){
                node = parent[node][j];
                if(node == -1){
                    return -1;
                }
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */