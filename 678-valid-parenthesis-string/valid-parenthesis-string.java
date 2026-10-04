class Solution {

    public boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {

                minOpen++;
                maxOpen++;

            } else if (ch == ')') {

                minOpen--;
                maxOpen--;

            } else { // '*'

                minOpen--;
                maxOpen++;
            }

            // Even the best case has too many ')'
            if (maxOpen < 0) {
                return false;
            }

            // We cannot have negative minimum possible opens
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        return minOpen == 0;
    }
}