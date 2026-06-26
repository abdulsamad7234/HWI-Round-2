class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length - 1, nums);
    }

    int countPairs(int l, int mid, int r, int[] nums){
        int count = 0;
        int j = mid + 1;
        for(int i = l; i <= mid; i++){
            while(j <= r && nums[i] > (long)2 * nums[j]){
                j++;
            }
            count += (j - (mid + 1));
        }
        return count;
    }

    int mergeSort(int l, int r, int[] nums){
        if(l >= r){
            return 0;
        }
        int count = 0;
        int mid = l + (r - l) / 2;
        count += mergeSort(l, mid, nums);
        count += mergeSort(mid + 1, r, nums);
        count += countPairs(l, mid, r, nums);
        merge(l, mid, r, nums);
        return count;
    }

    void merge(int l, int mid, int r, int[] nums){
        int[] temp = new int[r - l + 1];
        int ptr1 = l;
        int ptr2 = mid + 1;
        int ptr3 = 0;
        while(ptr1 <= mid && ptr2 <= r){
            if(nums[ptr1] <= nums[ptr2]){
                temp[ptr3++] = nums[ptr1++];
            }else{
                temp[ptr3++] = nums[ptr2++];
            }
        }
        while(ptr1 <= mid){
            temp[ptr3++] = nums[ptr1++];
        }
        while(ptr2 <= r){
            temp[ptr3++] = nums[ptr2++];
        }

        for(int i = l; i <= r; i++){
            nums[i] = temp[i - l];
        }
    }
}