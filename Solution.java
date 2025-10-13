//54 leetcode
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // move right along top row
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;

            // move down along right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // move left along bottom row, if still valid
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // move up along left column, if still valid
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> output1 = sol.spiralOrder(matrix1);
        System.out.println("Output 1: " + output1);
        // Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Example 2
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        List<Integer> output2 = sol.spiralOrder(matrix2);
        System.out.println("Output 2: " + output2);
        // Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
