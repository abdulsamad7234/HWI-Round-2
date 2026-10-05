class Solution {
    public int scoreOfParentheses(String s) {
        int totalScore = 0;
        int nestingDepth = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (currentChar == '(') {
                nestingDepth++;
            } else {
                nestingDepth--;
                // If the previous character was '(', it's a primitive "()", 
                // so we add 2^(nestingDepth) to our score.
                if (s.charAt(i - 1) == '(') {
                    totalScore += (1 << nestingDepth);
                }
            }
        }
        
        return totalScore;
    }
}