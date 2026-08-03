class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            if(map.containsKey(nums[i])){
                count = map.get(nums[i]);
            }
            map.put(nums[i], count + 1);
            pq.offer(new Pair(nums[i], count + 1));
        }

        int[] ans = new int[k];
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while(i != k){
            Pair curr = pq.poll();
            if(!set.contains(curr.value)){
                ans[i] = curr.value;
                set.add(curr.value);
                i++;
            }
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