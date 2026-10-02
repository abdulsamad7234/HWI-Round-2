class Solution {
    public String reverseWords(String s) {

        s = s.trim();

        StringBuilder stb = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) != ' ') {
                stb.append(s.charAt(i));
            } 
            else if (stb.length() > 0 && stb.charAt(stb.length() - 1) != ' ') {
                stb.append(' ');
            }

            i++;
        }

        int left = 0;

        for (int right = 0; right < stb.length(); right++) {

            if (stb.charAt(right) == ' ') {
                reverse(left, right - 1, stb);
                left = right + 1;
            }
        }

        reverse(left, stb.length() - 1, stb);

        reverse(0, stb.length() - 1, stb);

        return stb.toString();
    }

    void reverse(int i, int j, StringBuilder stb) {

        while (i < j) {
            char temp = stb.charAt(i);

            stb.setCharAt(i, stb.charAt(j));
            stb.setCharAt(j, temp);

            i++;
            j--;
        }
    }
}