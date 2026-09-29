class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int max_pairs = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n - 1; i++){
            int a = nums[i];
            int b = nums[i + 1];
            if(a == b){
                ans++;
            }else{
                String curr = String.valueOf(Math.min(a, b)) + "-" + String.valueOf(Math.max(a, b));
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                max_pairs = Math.max(max_pairs, map.get(curr));
            }
        }
        return ans + max_pairs;
    }

    class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}