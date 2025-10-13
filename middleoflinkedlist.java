//876 leetcode
public class middleoflinkedlist {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] sub = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int num = c - '1';
                int subIndex = (i / 3) * 3 + (j / 3);

                if (rows[i][num] || cols[j][num] || sub[subIndex][num]) {
                    return false;
                }

                rows[i][num] = true;
                cols[j][num] = true;
                sub[subIndex][num] = true;
            }
        }

        return true;
    }
}

