class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int x : piles){
            high = Math.max(high, x);
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canEat(mid, h, piles)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean canEat(int mid, int h, int[] piles){
        long count = 0;
        for(int i = 0; i < piles.length; i++){
            count += piles[i] / mid;
            if(piles[i] % mid !=  0){
                count++;
            }
        }
        if(count <= h){
            return true;
        }
        return false;
    }
}