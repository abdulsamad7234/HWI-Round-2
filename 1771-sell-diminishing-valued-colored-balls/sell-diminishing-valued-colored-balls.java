class Solution {
    static int MOD = 1_000_000_007;
    public int maxProfit(int[] inventory, int orders) {
        int l = 0;
        int r = 0;
        for(int x : inventory){
            r = Math.max(r, x);
        }

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(find(mid, inventory) >= orders){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        int val = l;

        long ans = 0;
        long remaining = orders;
        for(int x : inventory){
            if(x > val){
                long count = x - val;
                ans = (ans + findSum(x, val)) % MOD;
                remaining -= count;
            }
        }
        ans = (ans + remaining * val) % MOD;
        return (int)(ans);
    }

    long findSum(int left, int right){
        long count = left - right;
        long first = left;
        long last = right + 1;
        return (first + last) * count / 2;
    }

    long find(int mid, int[] inventory){
        long count = 0;
        for(int x : inventory){
            if(x > mid){
                count += x - mid;
            }
        }
        return count;
    }
}