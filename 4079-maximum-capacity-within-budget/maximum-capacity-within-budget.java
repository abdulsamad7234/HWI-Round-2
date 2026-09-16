class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = capacity.length;

        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = costs[i];
            arr[i][1] = capacity[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] prefix = new int[n];
        prefix[0] = arr[0][1];
        for(int i = 1; i < n; i++){
            prefix[i] = Math.max(prefix[i- 1], arr[i][1]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(costs[i] < budget){
                ans = Math.max(ans, capacity[i]);
            }
        }

        for(int i = 0; i < n; i++){
            int remaining = budget - arr[i][0] - 1;
            if(remaining <= 0){
                continue;
            }

            int idx = findUpperBound(remaining, arr, i - 1);

            if(idx != -1){
                ans = Math.max(ans, arr[i][1] + prefix[idx]);
            }
        }

        return ans;

    }
    int findUpperBound(int remaining, int[][] arr, int high){
        int l = 0;
        int r = high;
        int ans = -1;
        while(l <= r){
            int mid  = l + (r - l) / 2;
            if(arr[mid][0] <= remaining){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }
}