class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.s;
            int step = curr.step;
            if(word.equals(endWord)) return step;
            for(int i = 0; i < word.length(); i++){
                char[] arr = word.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    arr[i] = c;
                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.add(new Pair(newWord, step + 1));
                    }
                }
            }
        }
        return 0;
    }

    class Pair{
        String s;
        int step;
        Pair(String s, int step){
            this.s = s;
            this.step = step;
        }
    }
}