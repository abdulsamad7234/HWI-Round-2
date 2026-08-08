class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length){
            return -1;
        }
        int l = 1;
        int r = 0;
        for(int x : bloomDay){
            r = Math.max(r, x);
        }
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(isPossible(mid, m, k, bloomDay)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    boolean isPossible(int day, int m, int k, int[] bloomDay){
        int flowers = 0;
        int bouquets = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= day){
                flowers++;
                if(flowers == k){
                    bouquets++;
                    flowers = 0;
                }
            }else{
                flowers = 0;
            }
        }
        if(bouquets >= m){
            return true;
        }
        return false;
    }
}