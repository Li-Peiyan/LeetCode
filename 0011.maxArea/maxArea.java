class Solution {
    public int maxArea(int[] height) {
        int front = 0, rear = (height.length - 1 );
        int n,max = 0;
        while( front < rear )
        {
            int h = Math.min(height[front], height[rear]);
            max = Math.max(max, h*(rear-front) );
            if(height[front] < height[rear])
            {
                n = height[front];front++;
                while( front < rear && n >= height[front] )front++;
            }
            else
            {
                n = height[rear];rear--;
                while( front < rear && n >= height[rear])rear--;
            }
        }
        return max;
    }
}
