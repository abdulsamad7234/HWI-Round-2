class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partition(s, 0, ans, list);
        return ans;
    }

    public void partition(String s, int i, List<List<String>> ans, List<String> list){
        if(i == s.length()){
            ans.add(new ArrayList<>(list));
        }
        for(int k = i; k < s.length(); k++){
            if(isPalindrome(s.substring(i, k + 1))){
                list.add(s.substring(i, k + 1));
                partition(s, k + 1, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}