class Solution {
    public int[][] merge(int[][] intervals) {
        int max = 0;
        for(int[] in : intervals) {
            max = Math.max(max, in[1]);
        }
        // 数轴axis，起始点的位置为正，终止点的位置为负
        int[] axis = new int[max + 1];
        // 标准flag，记录形如$[a,a]$的点区间
        boolean[] flag = new boolean[max + 1];
        // 初始化axis和flag
        for(int[] in : intervals) {
            axis[in[0]]++;
            axis[in[1]]--;
            if(in[0] == in[1]) flag[in[0]] = true;
        }
        // 合并区间
        List<int[]> l = new ArrayList();
        int stt = 0;
        int k = 0;

        /* 共有4种情况：
         *  k从零到正：这种情况表示是一个区间的开始
         *  k从正到正：这种情况表示有区间的嵌套
         *  k从正到零：这种情况表示是一个区间的结束
         *  k从零到零：这种情况表示没有区间或有一个点区间。
         */

        for(int i = 0; i <= max; i++) {
            if(k == 0) {
                // 从零到正，记录区间的起点
                if(axis[i] > 0) {
                    stt = i;
                    k = axis[i];
                }
                // 从零到零，检验是否有点区间
                else if(flag[i]) {
                    l.add(new int[]{i, i});
                }
            }
            else {
                // 计算k的变化
                k += axis[i];
                // 如果是从正到零，说明是区间的结束，记录结束
                if(k == 0) {
                    l.add(new int[]{stt, i});
                }
            }
        }
        // 修改格式，生成返回值。
        int[][] rslt = new int[l.size()][];
        for(int i = 0; i < l.size(); i++) {
            rslt[i] = l.get(i);
        }
        return rslt;
    }
}
