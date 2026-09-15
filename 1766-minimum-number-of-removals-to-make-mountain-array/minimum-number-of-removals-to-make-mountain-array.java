class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        List<Integer> left_len_LIS = new ArrayList<>();
        List<Integer> right_len_LIS = new ArrayList<>();
        for(int i = 0; i < n; i++){
            left_len_LIS.add(1);
            right_len_LIS.add(1);
        }
        findLIS(nums, left_len_LIS);
        reverse(nums);
        findLIS(nums, right_len_LIS);
        Collections.reverse(right_len_LIS);
        reverse(nums);

        int len = 0;
        
        for(int i = 1; i < n - 1; i++){
            if(left_len_LIS.get(i) > 1 && right_len_LIS.get(i) > 1){
                len = Math.max(len, left_len_LIS.get(i) + right_len_LIS.get(i) - 1);
            }
        }

        return n - len;
    }

    List<Integer> findLIS(int[] nums, List<Integer> len_LIS){
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            int idx = findLowerBound(curr, list);
            if(idx == list.size()){
                list.add(curr);
            }else{
                list.set(idx, curr);
            }
            len_LIS.set(i, idx + 1);
        }
        return len_LIS;
    }

    int findLowerBound(int ele, List<Integer> list){
        int l = 0;
        int r = list.size() - 1;
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(list.get(mid) >= ele){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans == -1 ? list.size() : ans;
    }

    void reverse(int[] nums){
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
    }
}