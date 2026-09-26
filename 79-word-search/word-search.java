class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && find(i, j, 0, word, board)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(int i, int j, int idx, String word, char[][] board){
        if(idx == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '$' || board[i][j] != word.charAt(idx)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        boolean up = find(i - 1, j, idx + 1, word, board);
        boolean down = find(i + 1, j, idx + 1, word, board);
        boolean left = find(i, j - 1, idx + 1, word, board);
        boolean right = find(i, j + 1, idx + 1, word, board);

        board[i][j] = temp;
        return up || down || left || right;
    }
}