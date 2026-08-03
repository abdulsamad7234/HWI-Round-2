class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        List<Integer> list = new ArrayList<>();
        for(int i = n - k; i < n; i++){
            list.add(nums[i]);
        }
        for(int i = 0; i < n - k; i++){
            list.add(nums[i]);
        }
        for(int i = 0; i < n; i++){
            nums[i] = list.get(i);
        }
    }
}