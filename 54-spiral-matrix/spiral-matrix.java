class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;

        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // 1. Top: left → right
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            top++;

            // 2. Right: top → bottom
            for (int row = top; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            right--;

            // Are there rows/columns remaining?
            if (top <= bottom) {

                // 3. Bottom: right → left
                for (int col = right; col >= left; col--) {
                    res.add(matrix[bottom][col]);
                }

                bottom--;
            }

            if (left <= right) {

                // 4. Left: bottom → top
                for (int row = bottom; row >= top; row--) {
                    res.add(matrix[row][left]);
                }

                left++;
            }
        }

        return res;
    }
}