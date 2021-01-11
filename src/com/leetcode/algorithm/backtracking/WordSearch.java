package com.leetcode.algorithm.backtracking;

public class WordSearch {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word){
        char[] w = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (backtrack(board, i, j, w, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int row, int col, char[] w, int index){
        if (index == w.length)
            return true;
        // visited[row][col]是为防止word逆向，不可重复探查
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col])
            return false;
        if (w[index] != board[row][col])
            return false;

        visited[row][col] = true;

        if (backtrack(board, row + 1, col, w, index + 1)
        || backtrack(board, row - 1, col, w, index + 1)
        || backtrack(board, row, col + 1, w, index + 1)
        || backtrack(board, row, col - 1, w, index + 1))
            return true;

        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'F'}
        };
        String word = "ABCCED";
        WordSearch wordSearch = new WordSearch();
        wordSearch.exist(board, word);
    }
}
