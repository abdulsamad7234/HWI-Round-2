class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        int i = 0;
        ArrayList<Character> list = new ArrayList<>();
        while(i < n){
            list.add(s.charAt(i));
            while(list.size() > 1 && list.get(list.size() - 1) == list.get(list.size() - 2)){
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
            i++;
        }
        StringBuilder ans = new StringBuilder();
        for(char c : list){
            ans.append(c);
        }
        return ans.toString();
    }
}