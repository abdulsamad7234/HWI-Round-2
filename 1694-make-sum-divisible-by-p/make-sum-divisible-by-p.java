class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;
        for(int x : nums){
            totalSum += x;
        }
        int need = (int)(totalSum % p);
        if(need == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int minL = Integer.MAX_VALUE;
        int curr = 0;
        for(int i = 0; i < n; i++){
            curr = (curr + nums[i]) % p;
            int target = (curr - need) % p;
            if(target < 0){
                target += p;
            }
            if(map.containsKey(target)){
                int idx = map.get(target);
                if(i - idx < minL){
                    minL = i - idx;
                }
            }
            map.put(curr, i);
        }

        if(minL == Integer.MAX_VALUE || minL == n){
            return -1;
        }
        return minL;
    }
}