class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int leftLine = 0, rightLine = matrix.length - 1;//行数
        int leftColumn = 0, rightColumn = matrix[0].length - 1; //列数
        if(target < matrix[0][0] || target > matrix[rightLine][rightColumn]){//是否 min < target < max
            return false;
        }
    
        while(leftLine < rightLine){ //确定target所在行 //二分查找法
            int midLine = (leftLine + rightLine) >> 1;
            if(matrix[midLine][0] == target || matrix[midLine][rightColumn] == target){//是否等于中间行起始值或中间行末尾值
                return true;
            }
            if(matrix[midLine][0] < target){//中间行起始值 < target
                if(matrix[midLine][rightColumn] > target){//target < 中间行末尾值
                    //选中该行
                    leftLine = midLine;
                    rightLine = midLine;  
                }else{
                    leftLine = midLine + 1;//左行指针移动
                }
            }else{//target < 中间行起始值
                rightLine = midLine - 1;//右行指针移动
            }
        }
        while(leftColumn <= rightColumn){//确定target所在列 //二分查找法
            int midColumn = (leftColumn + rightColumn) >> 1;
            if(matrix[leftLine][midColumn] == target){//是否等于中间列值
                return true;
            }
            if(matrix[leftLine][midColumn] < target){
                leftColumn = midColumn + 1;//左列指针移动
            }else{
                rightColumn = midColumn - 1;//右列指针移动
            }
        }
        return false;
    }
}
