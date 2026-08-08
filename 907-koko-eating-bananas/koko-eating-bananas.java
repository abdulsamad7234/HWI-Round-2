class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        int l = 1;
        int r = max;

        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(isPossible(mid, h, piles)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    boolean isPossible(int speed, int h, int[] piles){
        long count = 0;
        for(int x : piles){
            if(x <= speed){
                count++;
            }else if(x % speed == 0){
                count += x / speed;
            }else{
                count += x / speed;
                count++;
            }
        }
        if(count <= h){
            return true;
        }
        return false;
    }
}