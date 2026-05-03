class Solution {
    public int nextGreaterElement(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;
        int idxToSwap = -1;
        for(int i = n - 1; i > 0; i--){
            if(arr[i - 1] < arr[i]){
                idxToSwap = i - 1;
                break;
            }
        }

        if(idxToSwap == -1) return -1;
        for(int i = n - 1; i > idxToSwap; i--){
            if(arr[i] > arr[idxToSwap]){
                swap(idxToSwap, i, arr);
                break;
            }
        }

        reverse(idxToSwap + 1, n - 1, arr);
        long ans = Long.parseLong(new String(arr));
        
        return (ans > Integer.MAX_VALUE) ? -1 : (int)ans;
    }

    public void reverse(int i, int j, char[] arr){
        while(i < j){
            swap(i, j, arr);
            i++;
            j--;
        }
    }

    public void swap(int i, int j, char arr[]){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}