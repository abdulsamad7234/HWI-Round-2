class Solution {
    static int MOD = (int) 1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int pse[] = new int[n];
        pse(pse, arr);
        int nse[] = new int[n];
        nse(nse, arr);

        long totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum = (totalSum + ((i - pse[i]) * (long)(nse[i] - i)) * arr[i]) % MOD;
        }
        return (int)totalSum;
    }

    void nse(int[] nse, int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = n;
            }else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
    }

    void pse(int[] pse, int[] arr){
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = st.peek();
            }
            st.push(i);
        }
    }
}