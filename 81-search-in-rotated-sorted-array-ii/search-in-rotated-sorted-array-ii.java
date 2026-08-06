class Solution {
    public boolean search(int[] arr, int target) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] == target){
                return true;
            }

            if(arr[l] == arr[mid] && arr[r] == arr[mid]){
                l++;
                r--;
            }else if(arr[l] <= arr[mid]){
                if(arr[l] <= target && arr[mid] > target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(arr[mid] < target && arr[r] >= target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }

        return false;
    }
}