class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansList = new ArrayList<int[]>();
        int left = newInterval[0], right = newInterval[1];
        boolean ri = true;//判断是否需要寻找右范围
        int i = 0, len = intervals.length;
        while(i < len && intervals[i][1] < left){ //在newInterval范围之外，小于
            ansList.add(intervals[i]);
            ++i;
        }
        if(i < len){
            if(right < intervals[i][0]){//在newInterval范围之外，大于
                ansList.add(new int[]{left, right});
                ansList.add(intervals[i]);
                ri = false;
            }else{//与newInterval左范围交汇
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            }
            i++;
        }
        while(i < len && ri){
            if(right <= intervals[i][1]){
                if(right < intervals[i][0]){//在newInterval范围之外，大于
                    ansList.add(new int[]{left, right});
                    ansList.add(intervals[i]);
                }else{//与newInterval右范围交汇
                    right = intervals[i][1];
                    ansList.add(new int[]{left, right});
                }
                ri = false;
            }
            ++i;
        }
        if(ri || len == 0){//intervals长度为0，或者右范围没取
            ansList.add(new int[]{left, right});
        }else{
            while(i < len){//intervals剩下的取完
                ansList.add(intervals[i]);
                ++i;
            }
        }
        int[][] ans = new int[ansList.size()][2];
        for (i = 0; i < ansList.size(); ++i) {//遍历读取新范围
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
