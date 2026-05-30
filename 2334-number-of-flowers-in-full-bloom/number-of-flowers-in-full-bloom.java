class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] start = new int[flowers.length];
        int[] end = new int[flowers.length];

        for(int i = 0; i < flowers.length; i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        
        int[] ans = new int[people.length];
        for(int i = 0; i < people.length; i++){
            int bloomed_already = findUpperBound(start, people[i]);
            int died_already = findLowerBound(end, people[i]);
            ans[i] = bloomed_already - died_already;
        }
        
        return ans;
    }

    public int findUpperBound(int arr[], int target){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] > target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return (ans == -1) ? arr.length : ans;
    }

    public int findLowerBound(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return (ans == -1) ? arr.length : ans;
    }
}