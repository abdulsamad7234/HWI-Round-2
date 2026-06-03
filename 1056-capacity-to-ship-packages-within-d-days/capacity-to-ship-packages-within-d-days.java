class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int x : weights){
            low = Math.max(low, x);
            high += x;
        }

        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, days, weights)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    boolean isPossible(int capacity, int days, int[] weights){
        int totalDays = 0;
        int curr = 0;
        for(int x : weights){
            if(curr + x > capacity){
                totalDays++;
                curr = x;
            }else{
                curr += x;
            }
        }
        totalDays++;
        if(totalDays <= days){
            return true;
        }
        return false;
    }
}