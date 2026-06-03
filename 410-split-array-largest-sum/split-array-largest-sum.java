class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int x : nums){
            low = Math.max(low, x);
            high += x;
        }

        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, k, nums)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return ans;
    }

    boolean isPossible(int sum, int k, int[] nums){
        int split = 0;
        int curr = 0;
        for(int x : nums){
            if(curr + x > sum){
                split++;
                curr = x;
            }else{
                curr += x;
            }
        }
        split++;
        if(split <= k){
            return true;
        }else{
            return false;
        }
    }
}