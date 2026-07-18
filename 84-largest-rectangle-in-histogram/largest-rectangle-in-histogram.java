class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int arr1[] = new int[n];
        pse(heights, arr1);
        int arr2[] = new int[n];
        nse(heights, arr2);

        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int area = heights[i] * (arr2[i] - arr1[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public void pse(int[] heights, int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                arr[i] = -1;
            }else{
                arr[i] = st.peek();
            }
            st.push(i);
        }
    }

    public void nse(int[] heights, int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                arr[i] = n;
            }else{
                arr[i] = st.peek();
            }
            st.push(i);
        }
    }
}