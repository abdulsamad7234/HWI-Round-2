class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right =0;
        for(int pack:weights){
            left = Math.max(left,pack);
            right+=pack;
        }
        int ans =0;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isValid(weights,days,mid)){
                ans = mid;
                right = mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    boolean isValid(int [] weights,int days,int cap){
        int taken = 0;
        int curr = 0;
        for(int pack:weights){
            if(curr+pack>cap){
                taken++;
                curr = pack;
            }else{
                curr += pack;
            }
            if(taken>days) return false;
        }
        if(curr!=0) taken++;
        return taken<=days;
    }
}