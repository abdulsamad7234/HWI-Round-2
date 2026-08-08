class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curr = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            curr = (curr + nums[i] + k) % k;
            if(curr < 0){
                curr += k;
            }
            if(map.containsKey(curr)){
                count += map.get(curr);
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return count;
    }
}