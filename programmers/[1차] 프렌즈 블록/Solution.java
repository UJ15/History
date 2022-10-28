https://school.programmers.co.kr/learn/courses/30/lessons/17679#

import java.util.*;

class Solution {
    private final Set<Block> set = new HashSet<>();

    public int solution(int m, int n, String[] board) {
        char[][] boardArr = new char[m][n];

        for (int i = 0 ; i < m ; i++) {
            boardArr[i] = board[i].toCharArray();
        }

        findSquere(m, n, boardArr);
        int answer = 0;

        while (!set.isEmpty()) {
            answer += set.size();
            boardArr = relocateBoard(m, n, boardArr);
            set.clear();
            findSquere(m, n, boardArr);
        }

        return answer;
    }

    private void findSquere(int m, int n, char[][] board) {
        for (int i = 0 ; i < m - 1 ; i++) {
            for (int j = 0 ; j < n - 1 ; j++) {
                if (board[i][j] == 'x') {
                    continue;
                }

                char curr = board[i][j];
                if (board[i + 1][j] == curr
                        && board[i][j + 1] == curr
                        && board[i + 1][j + 1] == curr) {
                    set.add(new Block(i, j));
                    set.add(new Block(i + 1, j));
                    set.add(new Block(i, j + 1));
                    set.add(new Block(i + 1, j + 1));
                }
            }
        }
    }

    private char[][] relocateBoard(int m, int n, char[][] board) {
        for (Block block : set) {
            board[block.x][block.y] = 'x';
        }

        for (int i = 1 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (board[i][j] != 'x') {
                    continue;
                }

                for (int k = i ; k > 0 ; k--) {
                    board[k][j] = board[k-1][j];
                    board[k-1][j] = 'x';
                }
            }
        }

        return board;
    }
}

class Block {
    public int x;
    public int y;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return x == block.x && y == block.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}