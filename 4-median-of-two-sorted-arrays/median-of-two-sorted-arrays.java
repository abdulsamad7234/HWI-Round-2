class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[len1 + len2];
        int idx = 0;
        int i = 0;
        int j = 0;
        while(i < len1 && j < len2){
            if(nums1[i] < nums2[j]){
                arr[idx] = nums1[i];
                idx++;
                i++;
            }else{
                arr[idx] = nums2[j];
                idx++;
                j++;
            }
        }
        while(i < len1){
            arr[idx] = nums1[i];
            idx++;
            i++;
        }
        while(j < len2){
            arr[idx] = nums2[j];
            idx++;
            j++;
        }

        if(arr.length % 2 != 0){
            return arr[arr.length / 2];
        }
        double median = (arr[(arr.length / 2) - 1] + arr[arr.length / 2]) / 2.0;
        return median;
    }
}