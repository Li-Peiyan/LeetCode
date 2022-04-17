class Solution {
    public List<List<Integer>> generate(int numRows) {
        // 存结果
        List<List<Integer>> res = new ArrayList<>();

        // 遍历每层
        for(int i = 0; i < numRows; ++i){
            List<Integer> list = new ArrayList<>();

            // 遍历每层的元素 
            for(int j = 0; j <= i; ++j){
                // 最左最右为 1
                if(j == 0 || j == i){
                    list.add(1);
                    continue;
                }

                // 上一层左右两元素之和
                list.add( res.get(i-1).get(j-1) + res.get(i-1).get(j) );
            }
            res.add(list);
        }

        return res;
    }
}
