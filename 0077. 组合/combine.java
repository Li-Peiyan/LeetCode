class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //嵌套调用
        com(1, n, k, ansList, list);
        return ansList;
    }

    public void com(int left, int right, int k, List<List<Integer>> ansList, List<Integer> list){
        //判断数量够的情况
        if(k == 0){
            ansList.add(new ArrayList<Integer>(list));
            return;
        }
        //遍历//剪枝
        for(int i = left; i <= right - k + 1; ++i){
            list.add(i);
            //嵌套调用遍历
            com(i+1, right, k-1, ansList, list);
            //删除最后一个数据
            list.remove(list.size() - 1);
        }
    }

}
