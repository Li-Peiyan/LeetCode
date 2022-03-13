class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1; 
        while (left <= right && top <= bottom) {
            for(int j = left; j <= right; j++){
                list.add(matrix[top][j]);
            }
            for(int i = top + 1; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for(int j = right - 1; j >= left; j--){
                    list.add(matrix[bottom][j]);
                }
                for(int i = bottom - 1; i > top; i--){
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }
}
