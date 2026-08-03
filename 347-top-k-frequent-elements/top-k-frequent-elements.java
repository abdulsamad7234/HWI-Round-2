class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            Pair curr = pq.poll();
            ans[i] = curr.value;
        }
        return ans;
    }

    class Pair{
        int value;
        int count;
        Pair(int value, int count){
            this.value = value;
            this.count = count;
        }
    }
}